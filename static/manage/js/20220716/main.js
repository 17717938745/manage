!function(){var e,t,n,r,o,a,i={466:function(e,t,n){"use strict";var r,o,a=n(3804),i=n.n(a),c=n(7196),u=n(1079);(0,c.render)(i().createElement(u.default,null),(r="",o=document.createElement(r||"div"),document.body.appendChild(o),o))},7496:function(e,t,n){"use strict";n.r(t);n(2222),n(9600),n(7042),n(9601),n(1539),n(8674);var r=n(3804),o=n.n(r),a=n(4775);function i(){return(i=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(e[r]=n[r])}return e}).apply(this,arguments)}t.default=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"./manage/",r=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{},c=e.slice(0,e.length-1).concat(e[e.length-1][0].toUpperCase()+e[e.length-1].slice(1)),u=(0,a.ZP)((function(){return n(1101)(t+c.join("/")+".tsx")}));return function(e){return o().createElement(u,i({},r,e))}}},3048:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return z}});n(2526),n(1817),n(2165),n(2222),n(7327),n(9554),n(2772),n(6992),n(9600),n(1249),n(7042),n(561),n(8309),n(9653),n(1539),n(4916),n(8783),n(3123),n(4747),n(3948);var r=n(3804),o=n.n(r),a=n(847),i=n(1120),c=n(8920),u=n(998),s=n(6869),l=n(5757),f=n(6037),p=n(2822),m=n(2318),d=n(5517),h=n(5834),g=n(5258),v=n(8358),y=n(7812),b=n(770),E=n(9659),w=n(7655),O=n(5639),x=n(4436),k=n(6019),S=n(7162),j=n(553),P=n(74),C=n(2613),Z=n(2112),N=n(1337),A=n(8607),I=n(7496),T=n(6657),R=n.p+"img/20220716/logo.png",_=n.p+"img/20220716/expand-less.svg",M=n.p+"img/20220716/expand-more.svg",D=n.p+"img/20220716/folder.svg",L=n.p+"img/20220716/folder-open.svg",B=n.p+"img/20220716/insert-drive-file.svg",J=n.p+"img/20220716/menu.svg",U=n.p+"img/20220716/more-vert.svg";function q(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function F(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?q(Object(n),!0).forEach((function(t){H(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):q(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function H(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function K(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){if("undefined"==typeof Symbol||!(Symbol.iterator in Object(e)))return;var n=[],r=!0,o=!1,a=void 0;try{for(var i,c=e[Symbol.iterator]();!(r=(i=c.next()).done)&&(n.push(i.value),!t||n.length!==t);r=!0);}catch(e){o=!0,a=e}finally{try{r||null==c.return||c.return()}finally{if(o)throw a}}return n}(e,t)||function(e,t){if(!e)return;if("string"==typeof e)return $(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);"Object"===n&&e.constructor&&(n=e.constructor.name);if("Map"===n||"Set"===n)return Array.from(e);if("Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))return $(e,t)}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function $(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,r=new Array(t);n<t;n++)r[n]=e[n];return r}var G=180,W=240;function z(e){var t=(0,T.fS)(),n=e.window,q=e.children,$=e.history,z=e.routeList,X=e.onPaletteSelectChange,V=K(o().useState(!1),2),Y=V[0],Q=V[1],ee=K((0,r.useState)(t),2),te=ee[0],ne=ee[1],re=K((0,r.useState)(null),2),oe=re[0],ae=re[1],ie=K((0,r.useState)((0,A.AN)(z,t)),2),ce=ie[0],ue=ie[1],se=K((0,r.useState)(new Array),2),le=se[0],fe=se[1],pe=(0,i.Z)((function(e){var t,n,r;return{menuItem:{color:e.palette.primary.light},container:{display:"flex",minHeight:"100vh"},appBar:(t={},H(t,e.breakpoints.up("sm"),{width:"calc(100% - ".concat(G,"px)"),marginLeft:G}),H(t,e.breakpoints.up("md"),{width:"calc(100% - ".concat(W,"px)"),marginLeft:W}),t),menuButton:H({marginRight:e.spacing(2)},e.breakpoints.up("sm"),{display:"none"}),content:{flexGrow:1,padding:e.spacing(3)},contentShift:{transition:e.transitions.create("margin",{easing:e.transitions.easing.easeOut,duration:e.transitions.duration.enteringScreen}),marginLeft:0},root:{width:"100%",maxWidth:360},drawer:(n={},H(n,e.breakpoints.up("sm"),{width:G,flexShrink:0}),H(n,e.breakpoints.up("md"),{width:W,flexShrink:0}),n),toolbar:e.mixins.toolbar,drawerPaper:(r={},H(r,e.breakpoints.up("sm"),{width:G}),H(r,e.breakpoints.up("md"),{width:W}),r),nested:{paddingLeft:e.spacing(4)},link:{textDecoration:"none",color:"inherit"},drawerHeader:F(F({padding:e.spacing(0,1)},e.mixins.toolbar),{},{display:"flex",justifyContent:"flex-start",alignItems:"center"}),closeIcon:{position:"absolute",right:e.spacing(1)},hide:{display:"none"},rightButtonGroup:{position:"absolute",right:0}}}))(),me=(0,c.Z)(),de=function(){Q(!Y)},he=function e(t){var n=arguments.length>1&&void 0!==arguments[1]?arguments[1]:t,r=arguments.length>2&&void 0!==arguments[2]?arguments[2]:[],i=arguments.length>3&&void 0!==arguments[3]?arguments[3]:[],c=arguments.length>4&&void 0!==arguments[4]?arguments[4]:[],m=arguments.length>5&&void 0!==arguments[5]?arguments[5]:[];return(n||[]).forEach((function(n){var d=n.children||[],h=d.length>0,g=(new Array).concat(i).concat(n.component.split("/")),v=(new Array).concat(r).concat(n.path.split("/")),y=n.name,b="/".concat(v.join("/")),E=h?ce.indexOf(b)>=0?o().createElement("img",{src:L,alt:"FolderOpen",className:"side-bar-svg"}):o().createElement("img",{src:D,alt:"Folder",className:"side-bar-svg"}):o().createElement("img",{src:B,alt:"InsertDriveFile",className:"side-bar-svg"});if(h){c.push(o().createElement(u.Z,{button:!0,key:b,onClick:function(){var e=(new Array).concat(ce),t=e.indexOf(b);t<0?e.push(b):e.splice(t,1),ue(e),ne(b)},className:pe.menuItem},o().createElement(s.Z,null,E),o().createElement(l.Z,{primary:y}),ce.indexOf(b)>=0?o().createElement("img",{src:_,alt:"ExpandLess",className:"side-bar-svg"}):o().createElement("img",{src:M,alt:"ExpandMore",className:"side-bar-svg"})));var w=[];e(t,d,v,g,w,m),c.push(o().createElement(f.Z,{key:b+"collapse",in:ce.indexOf(b)>=0,timeout:"auto",unmountOnExit:!0},o().createElement(p.Z,{disablePadding:!0,style:{paddingLeft:20*(r.length+1)}},w)))}else{var O=(0,I.default)(g);m.push(o().createElement(a.Route,{key:"children-route-".concat(b),path:"".concat(b),component:function(){return o().createElement(O,null)}})),c.push(o().createElement(u.Z,{key:b,onClick:function(){var e=(new Array).concat(ce);e.indexOf(b)<0&&e.push(b),ue(e),ne(b),$.push(b)},button:!0,className:pe.menuItem},o().createElement(s.Z,null,E),o().createElement(l.Z,{primary:y})))}})),[c,m]}(z,z);(0,r.useEffect)((function(){fe(he[1])}),["admin"]);var ge=void 0!==n?function(){return n().document.body}:void 0,ve=o().createElement("div",null,o().createElement("div",{className:pe.drawerHeader},o().createElement("img",{src:R,alt:"logo",style:{height:30}}),o().createElement(m.Z,null,"后台管理")),o().createElement(d.Z,null),o().createElement(p.Z,{component:"nav",color:"inherit"},he[0])),ye=K((0,r.useState)(-1),2),be=ye[0],Ee=ye[1],we=[{primary:{light:"#746c3e",main:"#a87c30",dark:"#12d216",contrastText:"#fff"},secondary:{light:"#ceccbc",main:"#2474d5",dark:"#5110d5",contrastText:"#000"}},{primary:{light:"#8186cb",main:"#4caa45",dark:"#a91ee5",contrastText:"#fff"},secondary:{light:"#aedca4",main:"#14c7e7",dark:"#e21c29",contrastText:"#000"}}];return o().createElement("div",{className:pe.container},o().createElement(h.ZP,null),o().createElement(g.Z,{position:"fixed",className:pe.appBar},o().createElement(v.Z,null,o().createElement(y.Z,{color:"inherit","aria-label":"open drawer",onClick:de,edge:"start",className:pe.menuButton},o().createElement("img",{src:J,alt:"MenuIcon",className:"side-bar-svg"})),o().createElement(b.Z,{color:"inherit"},te.split("/").filter((function(e){return e})).map((function(e,t,n){var r=(0,A.HM)(z,n.slice(0,t+1)),a="/"+(new Array).concat(n).slice(0,t+1).join("/");return t<n.length-1?o().createElement(E.Z,{key:a,style:{cursor:"pointer"},color:"inherit",onClick:function(){}},r):o().createElement(m.Z,{key:a},r)}))),o().createElement("div",{className:pe.rightButtonGroup},o().createElement(y.Z,{"aria-haspopup":"true",onClick:function(e){ae(e.currentTarget)}},o().createElement("img",{src:U,alt:"MoreVert",className:"side-bar-svg"})),o().createElement(w.Z,{style:{transformOrigin:"left bottom"},color:"inherit",anchorEl:oe,open:Boolean(oe),onClose:function(){ae(null)}},X?o().createElement(O.Z,null,o().createElement(x.Z,{component:"fieldset",fullWidth:!0},o().createElement(k.Z,{component:"legend"},"一键换肤"),o().createElement(S.Z,{value:be,onChange:function(e){var t=Number(e.target.value);Ee(t),X(we[t])}},we.map((function(e,t){return o().createElement(j.Z,{key:"palette-".concat(t),value:t,control:o().createElement(P.Z,null),label:"皮肤".concat(t+1)})}))))):null,o().createElement(O.Z,{onClick:function(){ae(null),(0,T.v_)("login/signOut",{}).then((function(){(0,T.eq)()}))}},"登出"))))),o().createElement("nav",{className:pe.drawer,color:"inherit"},o().createElement(C.Z,{smUp:!0,implementation:"css"},o().createElement(Z.ZP,{container:ge,variant:"temporary",anchor:"rtl"===me.direction?"right":"left",open:Y,color:"inherit",classes:{paper:pe.drawerPaper},onClose:de,ModalProps:{keepMounted:!0}},ve)),o().createElement(C.Z,{xsDown:!0,implementation:"css"},o().createElement(Z.ZP,{classes:{paper:pe.drawerPaper},color:"inherit",variant:"permanent",open:!0},ve))),o().createElement(N.Z,{component:"div",className:pe.content},o().createElement("div",{className:pe.toolbar}),q,o().createElement(a.Router,{history:$},o().createElement(a.Switch,null,le,o().createElement(a.Route,{component:function(){return o().createElement("div",null," ")}})))))}},1079:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return Z}});n(2526),n(1817),n(2165),n(6992),n(1539),n(8674),n(8783),n(3948),n(5666);var r=n(3804),o=n.n(r),a=n(847),i=n(4371),c=n(4995),u=n(1337),s=n(6912),l=n(2663),f=n(6083),p=n(9525),m=n(7212),d=n(6856),h=n(282),g=n(5834),v=n(3457),y=n(3293),b=n(8334),E=n(8607),w=n(6657),O=n(3048),x=n(7496);function k(e,t,n,r,o,a,i){try{var c=e[a](i),u=c.value}catch(e){return void n(e)}c.done?t(u):Promise.resolve(u).then(r,o)}function S(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){if("undefined"==typeof Symbol||!(Symbol.iterator in Object(e)))return;var n=[],r=!0,o=!1,a=void 0;try{for(var i,c=e[Symbol.iterator]();!(r=(i=c.next()).done)&&(n.push(i.value),!t||n.length!==t);r=!0);}catch(e){o=!0,a=e}finally{try{r||null==c.return||c.return()}finally{if(o)throw a}}return n}(e,t)||function(e,t){if(!e)return;if("string"==typeof e)return j(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);"Object"===n&&e.constructor&&(n=e.constructor.name);if("Map"===n||"Set"===n)return Array.from(e);if("Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))return j(e,t)}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function j(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,r=new Array(t);n<t;n++)r[n]=e[n];return r}var P={messageOpen:!1,message:"ok",messageType:"success"},C=(0,i.lX)({basename:(0,w.Hw)()});function Z(){var e=S((0,r.useState)(new Array),2),t=e[0],i=e[1],j=S((0,r.useState)(P),2),Z=j[0],N=j[1],A=S((0,r.useState)({}),2),I=A[0],T=A[1],R=(0,c.Z)({status:{danger:b.Z[500]},palette:I});(0,r.useEffect)((function(){var e;(e=regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,n.e(648).then(n.t.bind(n,3648,19));case 2:return t=e.sent,e.abrupt("return",{total:t.total,list:(0,E.gI)(t.list)});case 4:case"end":return e.stop()}}),e)})),function(){var t=this,n=arguments;return new Promise((function(r,o){var a=e.apply(t,n);function i(e){k(a,r,o,i,c,"next",e)}function c(e){k(a,r,o,i,c,"throw",e)}i(void 0)}))})().then((function(e){i(e.list)})),(0,w.m$)((function(e){var t=e.data||{};if(t.hasOwnProperty("code")&&0!==t.code)return N({messageOpen:!0,message:"请求接口错误，错误代码：".concat(t.code),messageType:"error"}),Promise.reject(new Error("".concat(t.code)));try{return JSON.parse(t)}catch(e){return t}}),(function(e){return e&&e.response&&401===e.response.status&&L(!0),Promise.reject(e)}))}),["index"]);var _=function(){N((0,w.TS)(Z,{messageOpen:!1}))},M=S((0,r.useState)(!1),2),D=M[0],L=M[1];return o().createElement(u.Z,{color:"text.primary"},o().createElement(s.Z,{open:Z.messageOpen,anchorOrigin:{vertical:"top",horizontal:"center"},autoHideDuration:6e3,onClose:_},o().createElement(y.Z,{onClose:_,elevation:6,variant:"filled",severity:Z.messageType},Z.message||"ok")),o().createElement(l.Z,{open:D,onClose:function(){L(!1)}},o().createElement(f.Z,{id:"alert-dialog-title"},"注意！！！"),o().createElement(p.Z,null,o().createElement(m.Z,{id:"alert-dialog-description"},"认证失败，跳转到登陆页？")),o().createElement(d.Z,null,o().createElement(h.Z,{onClick:function(){L(!1)},color:"primary"},"关闭"),o().createElement(h.Z,{onClick:function(){N({messageOpen:!0,message:"跳转中...",messageType:"success"}),L(!1),(0,w.eq)()},color:"secondary",autoFocus:!0},"确定"))),o().createElement(g.ZP,null),o().createElement(v.Z,{theme:R},o().createElement(a.Router,{history:C},o().createElement(a.Switch,null,o().createElement(a.Route,{path:"/signIn",component:function(){var e=(0,x.default)(["signIn"]);return o().createElement(e,null)}}),o().createElement(a.Route,{key:"index",path:"/index",component:function(){var e=(0,x.default)(["dashboard"]);return o().createElement(e,null)}}),t.length>0?[o().createElement(O.default,{key:"admin",routeList:t,history:C,onPaletteSelectChange:function(e){T(e)}})]:null))))}(0,w.JB)(C)},8607:function(e,t,n){"use strict";n.d(t,{AN:function(){return u},gI:function(){return c},HM:function(){return s}});n(2222),n(7327),n(9554),n(2772),n(9600),n(8309),n(4747);function r(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function o(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}var i=function(){function e(t,n,o,i,c,u){r(this,e),a(this,"path",void 0),a(this,"componentPath",void 0),a(this,"component",void 0),a(this,"name",void 0),a(this,"icon",void 0),a(this,"children",void 0),this.path=t,this.component=n,this.componentPath=o,this.name=i,this.icon=c,this.children=u}var t,n,i;return t=e,(n=[{key:"addChild",value:function(e){this.children.push(e)}}])&&o(t.prototype,n),i&&o(t,i),e}(),c=function(e){for(var t=[],n={},r=1,o=function(){var o={};e=e.filter((function(e){var a,c=e.component,u=e.componentPath||"",s=e.path||c,l=e.parentPath,f=e.name,p=e.icon,m=new i(s,c,u,f,p,[]);if(1===r)(a=!l||s===l)&&t.push(m);else{var d=n[l];(a=null!=d)&&d.addChild(m)}return a&&(o[s]=m),!a})),++r,n=o};e.length>0;)o();return t},u=function e(t,n){var r=arguments.length>2&&void 0!==arguments[2]?arguments[2]:[],o=arguments.length>3&&void 0!==arguments[3]?arguments[3]:[];return t.forEach((function(t){var a=(new Array).concat(r).concat(t.path),i="/"+a.join("/"),c=t.children||[];c.length>0&&n.indexOf(i)>=0&&(o.push(i),e(c,n,a,o))})),o},s=function(e,t){var n=function(e,t){var n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:[];return t.forEach((function(t,r){var o=e.filter((function(e){return e.path===t}));if(o.length>0){var a=o[0];n[r]=a.name,e=a.children||[]}else n[r]=t})),n}(e,t);return n[n.length-1]}},6657:function(e,t,n){"use strict";n.d(t,{cF:function(){return U},po:function(){return J},fp:function(){return y},Gr:function(){return v},kJ:function(){return b},sO:function(){return E},$U:function(){return x},ws:function(){return I},U2:function(){return j},v_:function(){return C},uz:function(){return N},d9:function(){return R},m$:function(){return T},TS:function(){return _},Xh:function(){return M},aP:function(){return q},qb:function(){return L},lp:function(){return F},JB:function(){return H},Hw:function(){return K},fS:function(){return $},eY:function(){return G},qu:function(){return O},BN:function(){return W},eq:function(){return z}});n(7327),n(2772),n(9600),n(4986),n(7042),n(9653),n(6977),n(9601),n(1539),n(8674),n(4603),n(4916),n(9714),n(5306),n(4765),n(3123),n(6755),n(5666);var r=n(3262);function o(e,t,n,r,o,a,i){try{var c=e[a](i),u=c.value}catch(e){return void n(e)}c.done?t(u):Promise.resolve(u).then(r,o)}function a(e){return function(){var t=this,n=arguments;return new Promise((function(r,a){var i=e.apply(t,n);function c(e){o(i,r,a,c,u,"next",e)}function u(e){o(i,r,a,c,u,"throw",e)}c(void 0)}))}}var i,c=function(e){var t=e.data||{};if(t.hasOwnProperty("code")&&0!==t.code)return Promise.reject(new Error("".concat(t.code)));try{return JSON.parse(t)}catch(e){return t}},u=function(e){return e&&e.response&&401===e.response.status&&z(),Promise.reject(e)},s="pch_scope_device_id",l="pch_scope_pass_code",f="pch_scope_cipher_info",p="com.pch.",m="post",d="postJson",h="upload",g={},v=function(e){return"/"+e},y=function(e){if(null==e||""===e)return!0;if(E(e)){var t=0;for(var n in e)t++;return 0===t}return 0===e.length},b=function(e){return e&&"[object Array]"===Object.prototype.toString.call(e)},E=function(e){return e&&"[object Object]"===Object.prototype.toString.call(e)},w=function(e){return e&&"[object Number]"===Object.prototype.toString.call(e)},O=function(e,t){if(null==e)return-1;if(null==t)return 1;if(w(e)&&w(t))return e-t;for(var n=JSON.stringify(e),r=JSON.stringify(t),o=0;o<Math.min(n.length,r.length);o++){var a=n.charCodeAt(o)-r.charCodeAt(o);if(0!=a)return a}return n.length-r.length},x=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:0;try{return parseInt(e.replace(/[^0-9]/gi,""))}catch(e){return t}},k=function(e){return e.startsWith("auth/")||e.startsWith("/auth")},S=function(e,t,o){return new Promise((function(a,i){n.e(975).then(n.t.bind(n,9669,23)).then((function(n){var i=n.default.create({timeout:6e4,headers:{"Device-Id":D()},transformRequest:[function(e,t){return t["Pass-Code"]=F(),o?(0,r.aN)(e,B().publicKey,1):e}]});e[t]=i,a(i)}))}))},j=function(){var e=a(regeneratorRuntime.mark((function e(t){var n,r,o,a,i,s=arguments;return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(n=s.length>1&&void 0!==s[1]?s[1]:{},o=k(t),a="get",r=g[a+=o?"Cipher":""]){e.next=9;break}return e.next=7,S(g,a,!1);case 7:(r=e.sent).interceptors.response.use(c,u);case 9:return i=v(t),e.abrupt("return",r.get(i,{params:n}));case 11:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),P=function(e,t,o){return new Promise((function(a,i){n.e(975).then(n.t.bind(n,9669,23)).then((function(n){var i=n.default.create({timeout:6e4,headers:{"Device-Id":D(),"Content-Type":"application/x-www-form-urlencoded"},transformRequest:[function(e,t){t["Pass-Code"]=F();var n="";if(E(e)){for(var a in e)n+=encodeURIComponent(a)+"="+encodeURIComponent(e[a])+"&";n=n.substring(0,n.lastIndexOf("&"))}else n=e;return o?(0,r.aN)(n,B().publicKey,1):n}]});e[t]=i,a(i)}))}))},C=function(){var e=a(regeneratorRuntime.mark((function e(t){var n,r,o,a,i,s,l=arguments;return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(n=l.length>1&&void 0!==l[1]?l[1]:{},r=l.length>2&&void 0!==l[2]?l[2]:{},a=k(t),i=m,o=g[i+=a?"Cipher":""]){e.next=10;break}return e.next=8,P(g,i,!1);case 8:(o=e.sent).interceptors.response.use(c,u);case 10:return s=v(t),e.abrupt("return",o.post(s,n,r));case 12:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),Z=function(e,t,o){return new Promise((function(a,i){n.e(975).then(n.t.bind(n,9669,23)).then((function(n){var i=n.default.create({timeout:6e4,headers:{"Device-Id":D(),"Content-Type":"application/json;charset=UTF-8"},transformRequest:[function(e,t){var n;t["Pass-Code"]=F();try{n=JSON.stringify(e)}catch(t){n=e}return o?(0,r.aN)(n,B().publicKey):n}],transformResponse:[function(e){try{return JSON.parse(e)}catch(t){return e}}]});e[t]=i,a(i)}))}))},N=function(){var e=a(regeneratorRuntime.mark((function e(t){var n,r,o,a,i,s,l=arguments;return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(n=l.length>1&&void 0!==l[1]?l[1]:{},r=l.length>2&&void 0!==l[2]?l[2]:{},a=k(t),i=d,o=g[i+=a?"Cipher":""]){e.next=10;break}return e.next=8,Z(g,i,a);case 8:(o=e.sent).interceptors.response.use(c,u);case 10:return s=v(t),e.abrupt("return",o.post(s,n,r));case 12:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),A=function(e,t,o){return new Promise((function(a,i){n.e(975).then(n.t.bind(n,9669,23)).then((function(n){var i=n.default.create({timeout:6e4,headers:{"Device-Id":D(),"Content-Type":"multipart/form-data"},transformRequest:[function(e,t){return t["Pass-Code"]=F(),o?(0,r.aN)(e,B().publicKey,1):e}]});e[t]=i,a(i)}))}))},I=function(){var e=a(regeneratorRuntime.mark((function e(t,n){var r,o,a,i,s,l=arguments;return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(r=l.length>2&&void 0!==l[2]?l[2]:{},a=k(t),i=h,o=g[i+=a?"Cipher":""]){e.next=9;break}return e.next=7,A(g,i,!1);case 7:(o=e.sent).interceptors.response.use(c,u);case 9:return s=v(t),e.abrupt("return",o.post(s,n,r));case 11:case"end":return e.stop()}}),e)})));return function(t,n){return e.apply(this,arguments)}}(),T=function(e,t){c=e,u=t},R=function(e){return Object.assign(b(e)?[]:{},e)},_=function(e,t){return Object.assign(R(e),t)},M=function(e){return JSON.parse(JSON.stringify(e))},D=function(){var e=U(s);return e||(e=String((new Date).getTime())+String(Math.random()).substr(2,10),J(s,e)),e},L=function(e){J(f,JSON.stringify(e))},B=function(){try{return JSON.parse(U(f)||"")}catch(e){return{publicKey:"",privateKey:""}}},J=function(e,t){localStorage.setItem(p+e,t)},U=function(e){return localStorage.getItem(p+e)},q=function(e){J(l,e)},F=function(){return U(l)},H=function(e){i=e},K=function(){return""},$=function(){return"/"+location.pathname.split("/").slice(K()?K().split("/").length+1:0).filter((function(e){return e})).join("/")},G=function(){var e=location.search,t={};if(-1!=e.indexOf("?"))for(var n=(e=e.substr(1)).split("&"),r=0;r<n.length;r++){var o=n[r].split("=");t[o[0]]=unescape(o[1])}return t},W=function(e){i.push(e)},z=function(){"/signIn"!==$()&&W("/signIn?goBack=".concat($()))}},1101:function(e,t,n){var r={"./ManageAsyncLoadable.tsx":[7496],"./manage/Admin.tsx":[3048],"./manage/Dashboard.tsx":[8462,975,462],"./manage/Index.tsx":[1079],"./manage/SignIn.tsx":[9844,975,844],"./manage/other/Page404.tsx":[7093,93],"./manage/system/Menu.tsx":[3723,975,723],"./manage/system/Role.tsx":[5358,975,358],"./manage/system/User.tsx":[994,975,994],"./manage/tools/Html.tsx":[3889,975,48],"./manage/tools/MergeImage.tsx":[172,975,172],"./manage/tools/MergeTemplate.tsx":[9465,975,465]};function o(e){if(!n.o(r,e))return Promise.resolve().then((function(){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}));var t=r[e],o=t[0];return Promise.all(t.slice(1).map(n.e)).then((function(){return n(o)}))}o.keys=function(){return Object.keys(r)},o.id=1101,e.exports=o},3804:function(e){"use strict";e.exports=React},7196:function(e){"use strict";e.exports=ReactDOM},847:function(e){"use strict";e.exports=ReactRouterDOM}},c={};function u(e){if(c[e])return c[e].exports;var t=c[e]={exports:{}};return i[e](t,t.exports,u),t.exports}u.m=i,u.n=function(e){var t=e&&e.__esModule?function(){return e.default}:function(){return e};return u.d(t,{a:t}),t},t=Object.getPrototypeOf?function(e){return Object.getPrototypeOf(e)}:function(e){return e.__proto__},u.t=function(n,r){if(1&r&&(n=this(n)),8&r)return n;if("object"==typeof n&&n){if(4&r&&n.__esModule)return n;if(16&r&&"function"==typeof n.then)return n}var o=Object.create(null);u.r(o);var a={};e=e||[null,t({}),t([]),t(t)];for(var i=2&r&&n;"object"==typeof i&&!~e.indexOf(i);i=t(i))Object.getOwnPropertyNames(i).forEach((function(e){a[e]=function(){return n[e]}}));return a.default=function(){return n},u.d(o,a),o},u.d=function(e,t){for(var n in t)u.o(t,n)&&!u.o(e,n)&&Object.defineProperty(e,n,{enumerable:!0,get:t[n]})},u.f={},u.e=function(e){return Promise.all(Object.keys(u.f).reduce((function(t,n){return u.f[n](e,t),t}),[]))},u.u=function(e){return"js/20220716/"+e+".js"},u.miniCssF=function(e){return 975===e?"css/20220716/plugin.css":179===e?"css/20220716/main.css":"css/20220716/"+e+"."+e+".css"},u.g=function(){if("object"==typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"==typeof window)return window}}(),u.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},n={},r="webpack-react:",u.l=function(e,t,o){if(n[e])n[e].push(t);else{var a,i;if(void 0!==o)for(var c=document.getElementsByTagName("script"),s=0;s<c.length;s++){var l=c[s];if(l.getAttribute("src")==e||l.getAttribute("data-webpack")==r+o){a=l;break}}a||(i=!0,(a=document.createElement("script")).charset="utf-8",a.timeout=120,u.nc&&a.setAttribute("nonce",u.nc),a.setAttribute("data-webpack",r+o),a.src=e),n[e]=[t];var f=function(t,r){a.onerror=a.onload=null,clearTimeout(p);var o=n[e];if(delete n[e],a.parentNode&&a.parentNode.removeChild(a),o&&o.forEach((function(e){return e(r)})),t)return t(r)},p=setTimeout(f.bind(null,void 0,{type:"timeout",target:a}),12e4);a.onerror=f.bind(null,a.onerror),a.onload=f.bind(null,a.onload),i&&document.head.appendChild(a)}},u.r=function(e){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},u.p="/manage/",o=function(e){return new Promise((function(t,n){var r=u.miniCssF(e),o=u.p+r;if(function(e,t){for(var n=document.getElementsByTagName("link"),r=0;r<n.length;r++){var o=(i=n[r]).getAttribute("data-href")||i.getAttribute("href");if("stylesheet"===i.rel&&(o===e||o===t))return i}var a=document.getElementsByTagName("style");for(r=0;r<a.length;r++){var i;if((o=(i=a[r]).getAttribute("data-href"))===e||o===t)return i}}(r,o))return t();!function(e,t,n,r){var o=document.createElement("link");o.rel="stylesheet",o.type="text/css",o.onerror=o.onload=function(a){if(o.onerror=o.onload=null,"load"===a.type)n();else{var i=a&&("load"===a.type?"missing":a.type),c=a&&a.target&&a.target.href||t,u=new Error("Loading CSS chunk "+e+" failed.\n("+c+")");u.code="CSS_CHUNK_LOAD_FAILED",u.type=i,u.request=c,o.parentNode.removeChild(o),r(u)}},o.href=t,document.head.appendChild(o)}(e,o,t,n)}))},a={179:0},u.f.miniCss=function(e,t){a[e]?t.push(a[e]):0!==a[e]&&{48:1}[e]&&t.push(a[e]=o(e).then((function(){a[e]=0}),(function(t){throw delete a[e],t})))},function(){var e={179:0},t=[[466,975]];u.f.j=function(t,n){var r=u.o(e,t)?e[t]:void 0;if(0!==r)if(r)n.push(r[2]);else{var o=new Promise((function(n,o){r=e[t]=[n,o]}));n.push(r[2]=o);var a=u.p+u.u(t),i=new Error;u.l(a,(function(n){if(u.o(e,t)&&(0!==(r=e[t])&&(e[t]=void 0),r)){var o=n&&("load"===n.type?"missing":n.type),a=n&&n.target&&n.target.src;i.message="Loading chunk "+t+" failed.\n("+o+": "+a+")",i.name="ChunkLoadError",i.type=o,i.request=a,r[1](i)}}),"chunk-"+t)}};var n=function(){};function r(){for(var n,r=0;r<t.length;r++){for(var o=t[r],a=!0,i=1;i<o.length;i++){var c=o[i];0!==e[c]&&(a=!1)}a&&(t.splice(r--,1),n=u(u.s=o[0]))}return 0===t.length&&(u.x(),u.x=function(){}),n}u.x=function(){u.x=function(){},a=a.slice();for(var e=0;e<a.length;e++)o(a[e]);return(n=r)()};var o=function(r){for(var o,a,c=r[0],s=r[1],l=r[2],f=r[3],p=0,m=[];p<c.length;p++)a=c[p],u.o(e,a)&&e[a]&&m.push(e[a][0]),e[a]=0;for(o in s)u.o(s,o)&&(u.m[o]=s[o]);for(l&&l(u),i(r);m.length;)m.shift()();return f&&t.push.apply(t,f),n()},a=self.webpackChunkwebpack_react=self.webpackChunkwebpack_react||[],i=a.push.bind(a);a.push=o}(),u.x()}();