package com.pch.system.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.digest.SM3;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.pch.common.api.param.Relevance;
import com.pch.system.api.*;
import com.pch.system.api.bean.DeviceInfo;
import com.pch.system.api.entity.Menu;
import com.pch.system.api.entity.Role;
import com.pch.system.api.entity.User;
import com.pch.system.api.model.AuthToken;
import com.pch.system.api.param.SignIn;
import com.pch.system.api.param.SignOut;
import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/17 上午9:46
 */
@Slf4j
public class SystemImpl implements SystemApi {

    private static final String KEY_USER = "user";
    private static final String KEY_ROLE = "role";
    private static final String KEY_MENU = "menu";
    private static final String KEY_USER_ROLE = "userRole";
    private static final String KEY_ROLE_MENU = "roleMenu";
    private static final String STORAGE_FILE_NAME = "system_info.json";
    private static final String STORAGE_DEVICE_INFO = "system_device_info.json";
    private StorageApi storageApi;
    private Map<String, User> userMap = Collections.synchronizedMap(new LinkedHashMap<>());
    private Map<String, Role> roleMap = Collections.synchronizedMap(new LinkedHashMap<>());
    private Map<String, Menu> menuMap = Collections.synchronizedMap(new LinkedHashMap<>());
    private Map<String, Set<String>> userRoleMap = Collections.synchronizedMap(new LinkedHashMap<>());
    private Map<String, Set<String>> roleMenuMap = Collections.synchronizedMap(new LinkedHashMap<>());
    private Map<String, DeviceInfo> deviceInfoMap = Collections.synchronizedMap(new LinkedHashMap<>());
    private Random random;
    private UserApi userApi = new UserImpl();
    private RoleApi roleApi = new RoleImpl();
    private MenuApi menuApi = new MenuImpl();

    public SystemImpl(StorageApi storageApi) {
        this.storageApi = storageApi;
        /*try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            random = new Random();
        }*/
        random = new Random();
        String content = storageApi.load(STORAGE_FILE_NAME);
        if (null != content) {
            JSONObject fileJson = JSONUtil.parseObj(content, false, true);
            for (User user : fileJson.getJSONArray(KEY_USER).toList(User.class)) {
                userMap.put(user.getUsername(), user);
            }
            for (Role role : fileJson.getJSONArray(KEY_ROLE).toList(Role.class)) {
                roleMap.put(role.getCode(), role);
            }
            for (Menu menu : fileJson.getJSONArray(KEY_MENU).toList(Menu.class)) {
                menuMap.put(menu.getComponent(), menu);
            }
            userRoleMap.putAll(fileJson.getJSONObject(KEY_USER_ROLE).toBean(new TypeReference<LinkedHashMap<String, Set<String>>>() {
            }));
            roleMenuMap.putAll(fileJson.getJSONObject(KEY_ROLE_MENU).toBean(new TypeReference<LinkedHashMap<String, Set<String>>>() {
            }));
            content = storageApi.load(STORAGE_DEVICE_INFO);
            if (null != content) {
                for (DeviceInfo deviceInfo : JSONUtil.parseArray(content).toList(DeviceInfo.class)) {
                    deviceInfoMap.put(deviceInfo.getDeviceId(), deviceInfo);
                }
            }
        } else {
            final User user = new User();
            user.setUsername("admin");
            user.setPassword("112233");
            user.setName("管理员");
            user.setMobile("11111111111");
            userMap.put(user.getUsername(), user);
            storage();
        }
    }

    /**
     * Runtime.getRuntime().addShutdownHook(new Thread(this::storage));
     * storage user session in file
     */
    @Override
    public void storage() {
        Map<String, Object> fileJson = new LinkedHashMap<>();
        fileJson.put(KEY_USER, userMap.values());
        fileJson.put(KEY_ROLE, roleMap.values());
        fileJson.put(KEY_MENU, menuMap.values());
        fileJson.put(KEY_USER_ROLE, userRoleMap);
        fileJson.put(KEY_ROLE_MENU, roleMenuMap);
        storageApi.storage(STORAGE_FILE_NAME, JSONUtil.toJsonStr(fileJson));
        storageApi.storage(STORAGE_DEVICE_INFO, JSONUtil.toJsonStr(deviceInfoMap.values()));
    }

    public class UserImpl implements UserApi {

        @Override
        public List<Role> relateList(User user) {
            final Set<String> db = userRoleMap.get(user.getUsername());
            return null == db ? null : db.stream().map(str -> roleMap.get(str)).collect(Collectors.toList());
        }

        @Override
        public List<Role> relateRefresh(Relevance<User, Role> tr) {
            final Set<String> db = userRoleMap.computeIfAbsent(tr.getCurrent().getUsername(), k -> new HashSet<>());
            db.clear();
            db.addAll(tr.getTargetList().stream().map(Role::getCode).collect(Collectors.toList()));
            return new ArrayList<>(tr.getTargetList());
        }

        @Override
        public List<User> list() {
            return new ArrayList<>(userMap.values());
        }

        @Override
        public User save(User user) {
            User db;
            if (null == (db = userMap.get(user.getUsername()))) {
                userMap.put(user.getUsername(), db = user);
                return db;
            }
            return null;
        }

        @Override
        public User update(User user) {
            User db;
            if (null != (db = userMap.get(user.getUsername()))) {
                userMap.put(user.getUsername(), db = user);
                return db;
            }
            return null;
        }

        @Override
        public List<User> delete(List<User> list) {
            final List<User> userList = new ArrayList<>();
            for (User user : list) {
                User db;
                if (null != (db = userMap.get(user.getUsername()))) {
                    userMap.remove(db.getUsername());
                    userList.add(db);
                }
            }
            return userList.isEmpty() ? null : userList;
        }
    }

    public class RoleImpl implements RoleApi {

        @Override
        public List<Menu> relateList(Role role) {
            final Set<String> db = roleMenuMap.get(role.getCode());
            return null == db ? null : db.stream().map(str -> menuMap.get(str)).collect(Collectors.toList());
        }

        @Override
        public List<Menu> relateRefresh(Relevance<Role, Menu> tr) {
            final Set<String> db = roleMenuMap.computeIfAbsent(tr.getCurrent().getCode(), k -> new HashSet<>());
            db.clear();
            db.addAll(tr.getTargetList().stream().map(Menu::getComponent).collect(Collectors.toList()));
            return new ArrayList<>(tr.getTargetList());
        }

        @Override
        public List<Role> list() {
            return new ArrayList<>(roleMap.values());
        }

        @Override
        public Role save(Role role) {
            Role db;
            if (null == (db = roleMap.get(role.getCode()))) {
                roleMap.put(role.getCode(), db = role);
                return db;
            }
            return null;
        }

        @Override
        public Role update(Role role) {
            Role db;
            if (null != (db = roleMap.get(role.getCode()))) {
                roleMap.put(role.getCode(), db = role);
                return db;
            }
            return null;
        }

        @Override
        public List<Role> delete(List<Role> list) {
            List<Role> roleList = new ArrayList<>();
            for (Role role : list) {
                Role db;
                if (null != (db = roleMap.get(role.getCode()))) {
                    roleMap.remove(db.getCode());
                    roleList.add(db);
                }
            }
            return roleList.isEmpty() ? null : roleList;
        }
    }

    public class MenuImpl implements MenuApi {

        @Override
        public List<Menu> list() {
            return new ArrayList<>(menuMap.values());
        }

        @Override
        public Menu save(Menu menu) {
            Menu db;
            if (null == (db = menuMap.get(menu.getComponent()))) {
                menuMap.put(menu.getComponent(), db = menu);
                return db;
            }
            return null;
        }

        @Override
        public Menu update(Menu menu) {
            Menu db;
            if (null != (db = menuMap.get(menu.getComponent()))) {
                menuMap.put(menu.getComponent(), db = menu);
                return db;
            }
            return null;
        }

        @Override
        public List<Menu> delete(List<Menu> list) {
            List<Menu> menuList = new ArrayList<>();
            for (Menu menu : list) {
                Menu db;
                if (null != (db = menuMap.get(menu.getComponent()))) {
                    menuMap.remove(db.getComponent());
                    menuList.add(db);
                }
            }
            return menuList.isEmpty() ? null : menuList;
        }
    }

    @Override
    public UserApi userApi() {
        return userApi;
    }

    @Override
    public RoleApi roleApi() {
        return roleApi;
    }

    @Override
    public MenuApi menuApi() {
        return menuApi;
    }

    @Override
    public byte[] decrypt(String deviceId, byte[] bytes) {
        DeviceInfo deviceInfo = deviceInfoMap.get(deviceId);
        final String hexString = StrUtil.utf8Str(bytes);
        if (null != deviceInfo && null != deviceInfo.getServerPrivateKey() && null != deviceInfo.getServerPublicKey()) {
            try {
                SM2 sm2 = SmUtil.sm2(deviceInfo.getServerPrivateKey(), deviceInfo.getServerPublicKey());
                return sm2.decrypt(hexString, KeyType.PrivateKey);
            } catch (Exception e) {
                log.error("decrypt error, hexString : {}", hexString, e);
            }
        }
        return null;
    }

    @Override
    public AuthToken signIn(SignIn signIn) {
        final String deviceId = signIn.getDeviceId(),
                username = signIn.getUsername(),
                password = signIn.getPassword();
        final User userInStorage = userMap.get(username);
        final DeviceInfo deviceInfoStorage = deviceInfoMap.get(deviceId);
        if (null != deviceInfoStorage) {
            if (null != userInStorage) {
                final String hexDb = HexUtil.encodeHexStr(new SM3().digest(userInStorage.getPassword() + deviceInfoStorage.getPassCode()));
                if (password.equals(hexDb)) {
                    deviceInfoStorage.setUpdateMillis(System.currentTimeMillis());
                    deviceInfoStorage.setUser(userInStorage);
                    final KeyPair clientKeyPair = SecureUtil.generateKeyPair("SM2"),
                            serverKeyPair = SecureUtil.generateKeyPair("SM2");
                    deviceInfoStorage.setClientPrivateKey(clientKeyPair.getPrivate().getEncoded());
                    deviceInfoStorage.setClientPublicKey(clientKeyPair.getPublic().getEncoded());
                    deviceInfoStorage.setServerPrivateKey(serverKeyPair.getPrivate().getEncoded());
                    deviceInfoStorage.setServerPublicKey(serverKeyPair.getPublic().getEncoded());
                    final AuthToken authToken = new AuthToken();
                    authToken.setPublicKey(HexUtil.encodeHexStr(serverKeyPair.getPublic().getEncoded()));
                    authToken.setPrivateKey(HexUtil.encodeHexStr(clientKeyPair.getPrivate().getEncoded()));
                    return authToken;
                }
            }
            deviceInfoStorage.setPassCode(null);
        }
        return null;
    }

    @Override
    public boolean signOut(SignOut signOut) {
        final DeviceInfo deviceInfoInStorage = deviceInfoMap.computeIfPresent(signOut.getDeviceId(), (key, data) -> {
            data.setPassCode(null);
            return data;
        });
        return null != deviceInfoInStorage && null == deviceInfoInStorage.getPassCode();
    }

    @Override
    public boolean deviceSignIn(String deviceId) {
        final DeviceInfo deviceInfoInStorage = deviceInfoMap.computeIfPresent(deviceId, (key, data) -> {
            long currentTimeMillis = System.currentTimeMillis();
            data.setUpdateMillis(currentTimeMillis);
            return data;
        });
        return null != deviceInfoInStorage && null != deviceInfoInStorage.getPassCode() && null != deviceInfoInStorage.getServerPrivateKey() && null != deviceInfoInStorage.getServerPublicKey() && null != deviceInfoInStorage.getClientPrivateKey() && null != deviceInfoInStorage.getClientPublicKey();
    }

    @Override
    public String requestPassCode(String deviceId) {
        final String passCode = String.format("%10d", random.nextInt(1000000000)).replace(" ", "0");
        deviceInfoMap.computeIfAbsent(deviceId, key -> {
            long currentTimeMillis = System.currentTimeMillis();
            final DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setDeviceId(key);
            deviceInfo.setCreateMillis(currentTimeMillis);
            deviceInfo.setUpdateMillis(currentTimeMillis);
            return deviceInfo;
        }).setPassCode(passCode);
        return passCode;
    }
}