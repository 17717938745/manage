# Document

> 注
    
   修改```application-${env}.yml```中的数据库配置

    
- ```nginx```配置

        location /manage/ {
            proxy_pass http://localhost:8070/manage/;
        }

        #location ^~ /generate/ {
        #    alias /Users/pch/Program/resources/git/html-edit/static/generate/;
        #    index index.html;
        #    autoindex on;
        #    try_files $uri /generate/index.html;
        #}

        #location ^~ /html/edit/ {
        #    alias /Users/pch/Program/resources/git/html-edit/static/;
        #}
    
### 关于打包 ###
    
> package

    ./gradlew build
    
> scp

    scp manage-server/build/libs/manage-server-1.0.jar root@39.96.7.194:/opt/manage/manage-server-1.0.jar
    scp -r manage-server/src/main/resources/application-prd.yml root@39.96.7.194:/opt/manage/application-prd.yml
    scp -r static/ root@39.96.7.194:/opt/manage/static
    
> ssh

    ssh root@39.96.7.194

> run

    java -jar manage-server/build/libs/manage-server-1.0.jar --spring.config.location=manage-server/src/main/resources/application-mac.yml
    java -server -Xms64m -Xmx512m -XX:NewSize=64m -XX:MaxNewSize=64m -XX:+DisableExplicitGC -Dfile.encoding=utf-8 -Ddubbo.application.logger=slf4j -Djava.security.egd=file:/dev/./urandom -jar manage-server-1.0.jar --spring.config.location=./application-prd.yml 
    nohup java -server -Xms64m -Xmx512m -XX:NewSize=64m -XX:MaxNewSize=64m -XX:+DisableExplicitGC -Dfile.encoding=utf-8 -Ddubbo.application.logger=slf4j -Djava.security.egd=file:/dev/./urandom -jar manage-server-1.0.jar --spring.config.location=./application-prd.yml >/dev/null 2>&1 &

> shell

    app_name=manage
    app_version=1.0
    app_jar_name=${app_name}-server-${app_version}.jar
    echo "app_jar_name: ${app_jar_name}"
    cmd_find_pid="ps aux|grep ${app_jar_name}|grep -v grep|awk '{print \$2}'"
    echo ${cmd_find_pid}
    pid=`ps aux|grep ${app_jar_name}|grep -v grep|awk '{print $2}'`
    if [ "${pid}" == "" ]; then
        echo "${app_jar_name} not run..."
    else
        echo "pid: ${pid}"
        cmd_kill="kill ${pid}"
        echo ${cmd_kill}
        ${cmd_kill}
    fi
    cmd_run="nohup java -server -Xms64m -Xmx512m -XX:NewSize=64m -XX:MaxNewSize=64m -XX:+DisableExplicitGC -Dfile.encoding=utf-8 -Ddubbo.application.logger=slf4j -Djava.security.egd=file:/dev/./urandom -jar ${app_jar_name} --spring.config.location=./application-prd.yml >/dev/null 2>&1 &"
    echo ${cmd_run}
    nohup java -server -Xms64m -Xmx512m -XX:NewSize=64m -XX:MaxNewSize=64m -XX:+DisableExplicitGC -Dfile.encoding=utf-8 -Ddubbo.application.logger=slf4j -Djava.security.egd=file:/dev/./urandom -jar ${app_jar_name} --spring.config.location=./application-prd.yml >/dev/null 2>&1 &

- sample

    [https://mashable.com/](https://mashable.com/)
    
    http://localhost/manage/signIn?goBack=/system/html
    
    http://localhost/manage/system/html
    
    http://localhost/manage/dynamic/1624946292373

> other

    http://39.96.7.194/rest/20210726
    http://39.96.7.194/list
    [http://39.96.7.194/tools/mergeTemplate](http://39.96.7.194/tools/mergeTemplate)
    http://39.96.7.194/