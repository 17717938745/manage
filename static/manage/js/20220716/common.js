(self.webpackChunkwebpack_react=self.webpackChunkwebpack_react||[]).push([[592],{5518:function(e,t,n){"use strict";n.d(t,{Z:function(){return X}});n(2526),n(1817),n(2165),n(2222),n(7327),n(9554),n(2772),n(6992),n(1249),n(7042),n(561),n(1539),n(8783),n(4747),n(3948);var r=n(3804),a=n.n(r),l=n(1120),o=n(702),c=n(2663),i=n(6083),s=n(9525),u=n(7212),m=n(6856),f=n(282),p=n(9895),g=n(6847),d=n(2302),h=n(9613),y=n(7394),v=n(8222),b=n(7145),E=n(1657),k=n(553),Z=n(9570),S=n(3293),C=n(6657),w=n(9693),O=n(2318),A=n(868),x=n(7812),P=n(8358),T=n.p+"img/20220716/add.svg",N=n.p+"img/20220716/delete.svg",j=n.p+"img/20220716/edit.svg",R=n.p+"img/20220716/link.svg",D=n.p+"img/20220716/refresh.svg",I=n.p+"img/20220716/go-back.svg",z=n(6010);var U=(0,l.Z)((function(e){return{root:{paddingLeft:e.spacing(0),paddingRight:e.spacing(1)},highlight:"light"===e.palette.type?{color:e.palette.secondary.main,backgroundColor:(0,w.$n)(e.palette.secondary.light,.85)}:{color:e.palette.text.primary,backgroundColor:e.palette.secondary.dark},title:{padding:e.spacing(2),flex:"1 1 100%"}}}));function B(e){var t,n,r,l=U(),o=e.title,c=e.numSelected,i=e.onSave,s=e.onUpdate,u=e.onDelete,m=e.onRefresh,f=e.onShow,p=e.onRelate,g=[];return c<=0?(g.push(a().createElement(O.Z,{key:"tooltip-title",className:l.title,variant:"h6",id:"tableTitle",component:"div"},o)),g.push(a().createElement(A.ZP,{key:"tooltip-add",onClick:i,title:"新增"},a().createElement(x.Z,null,a().createElement("img",{src:T,alt:"Add",className:"table-tool-bar-svg"})))),g.push(a().createElement(A.ZP,{key:"tooltip-refresh",onClick:m,title:"刷新"},a().createElement(x.Z,null,a().createElement("img",{src:D,alt:"Refresh",className:"table-tool-bar-svg"}))))):(g.push(a().createElement(O.Z,{key:"select-title",className:l.title,color:"inherit",variant:"subtitle1",component:"div"},c," 条记录被选中")),1===c&&(g.push(a().createElement(A.ZP,{key:"tooltip-update",onClick:s,title:"更新"},a().createElement(x.Z,null,a().createElement("img",{src:j,alt:"Edit",className:"table-tool-bar-svg"})))),g.push(a().createElement(A.ZP,{key:"tooltip-relate",onClick:p,title:"show"},a().createElement(x.Z,null,a().createElement("img",{src:R,alt:"Link",className:"table-tool-bar-svg"}))))),g.push(a().createElement(A.ZP,{key:"tooltip-delete",onClick:u,title:"删除"},a().createElement(x.Z,null,a().createElement("img",{src:N,alt:"Delete",className:"table-tool-bar-svg"}))))),g.push(a().createElement(A.ZP,{key:"tooltip-show",onClick:f,title:"show"},a().createElement(x.Z,null,a().createElement("img",{src:I,alt:"GoBack",className:"table-tool-bar-svg"})))),a().createElement(P.Z,{className:(0,z.Z)(l.root,(t={},n=l.highlight,r=c>0,n in t?Object.defineProperty(t,n,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[n]=r,t))},g)}var L=n(3750),q=n(7121);function M(e){var t=e.headCells,n=e.onSelectAllClick,r=e.order,l=e.orderBy,o=e.numSelected,c=e.rowCount,i=e.onRequestSort;return a().createElement(L.Z,null,a().createElement(y.Z,null,a().createElement(v.Z,{padding:"checkbox"},a().createElement(b.Z,{indeterminate:o>0&&o<c,checked:c>0&&o>=c,onChange:n})),t.map((function(e){return a().createElement(v.Z,{key:e.key,align:e.numeric?"right":"left",padding:e.disablePadding?"none":"normal",sortDirection:l===e.key&&r},a().createElement(q.Z,{active:l===e.key,direction:l===e.key?r:"asc",onClick:(t=e.key,function(e){i(e,t)})},e.label));var t}))))}var $=n(9803);function F(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){if("undefined"==typeof Symbol||!(Symbol.iterator in Object(e)))return;var n=[],r=!0,a=!1,l=void 0;try{for(var o,c=e[Symbol.iterator]();!(r=(o=c.next()).done)&&(n.push(o.value),!t||n.length!==t);r=!0);}catch(e){a=!0,l=e}finally{try{r||null==c.return||c.return()}finally{if(a)throw l}}return n}(e,t)||function(e,t){if(!e)return;if("string"==typeof e)return W(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);"Object"===n&&e.constructor&&(n=e.constructor.name);if("Map"===n||"Set"===n)return Array.from(e);if("Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))return W(e,t)}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function W(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,r=new Array(t);n<t;n++)r[n]=e[n];return r}var _,G=(0,l.Z)((function(e){return{form:{padding:e.spacing(0,3)}}}));function H(e){var t=G(),n=e.title,l=e.submitUri,o=e.forms,u=e.open,p=e.onClose,g=e.onSuccess,d=e.onError,h=F((0,r.useState)(!1),2),y=h[0],v=h[1];(0,r.useEffect)((function(){}),[o]);var b=function(e){e.preventDefault();for(var t=!0,n={},r=0;r<o.length;r++){var a=o[r];if(a.hasOwnProperty("validList"))0===a.validList.length&&(a.error=!1);else{if(!a.value){a.error=!0,t=!1;break}a.error=!1}n[a.key]=a.value}t?(0,C.uz)(l,n).then((function(e){g(e)})).catch((function(e){d(e)})):v(!y)};return a().createElement(c.Z,{open:u,onClose:p},a().createElement(i.Z,null,n),a().createElement(s.Z,null,a().createElement("form",{onSubmit:b,className:t.form,noValidate:!0},o.map((function(e,t){var n=o[t],r=n.key,l=n.label,c=n.type||"text",i=n.helperText?n.helperText:"请填写正确的".concat(l);return a().createElement($.Z,{key:r,size:"small",type:c,value:e.value||"",onChange:function(t){e.value=t.currentTarget.value,v(!y)},variant:"outlined",margin:"normal",fullWidth:!0,label:l,autoFocus:0===t,error:e.error,helperText:e.error?i:""})})))),a().createElement(m.Z,null,a().createElement(f.Z,{onClick:p,color:"primary"},"取消"),a().createElement(f.Z,{onClick:b,color:"primary"},"提交")))}function J(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){if("undefined"==typeof Symbol||!(Symbol.iterator in Object(e)))return;var n=[],r=!0,a=!1,l=void 0;try{for(var o,c=e[Symbol.iterator]();!(r=(o=c.next()).done)&&(n.push(o.value),!t||n.length!==t);r=!0);}catch(e){a=!0,l=e}finally{try{r||null==c.return||c.return()}finally{if(a)throw l}}return n}(e,t)||function(e,t){if(!e)return;if("string"==typeof e)return V(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);"Object"===n&&e.constructor&&(n=e.constructor.name);if("Map"===n||"Set"===n)return Array.from(e);if("Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))return V(e,t)}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function V(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,r=new Array(t);n<t;n++)r[n]=e[n];return r}!function(e){e.DESC="desc",e.ASC="asc"}(_||(_={}));var K=(0,l.Z)((function(e){return{root:{width:"100%"},paper:{width:"100%",marginBottom:e.spacing(2)},table:{minWidth:750}}})),Q={messageOpen:!1,message:"ok",messageType:"success"};function X(e){var t=K(),n=e.headCells,l=e.form,w=J((0,r.useState)(!1),2),O=w[0],A=w[1],x=J((0,r.useState)(Q),2),P=x[0],T=x[1],N=J((0,r.useState)((0,C.d9)((l||{}).uri||{})),2),j=N[0],R=N[1],D=J((0,r.useState)([0]),2),I=D[0],z=D[1],U=J((0,r.useState)((l||{}).forms||[]),2),L=U[0],q=U[1],$=J((0,r.useState)(new Array),2),F=$[0],W=$[1],G=J((0,r.useState)(0),2),V=G[0],X=G[1],Y=J((0,r.useState)(_.ASC),2),ee=Y[0],te=Y[1],ne=J((0,r.useState)(""),2),re=ne[0],ae=ne[1],le=J((0,r.useState)(new Array),2),oe=le[0],ce=le[1],ie=J((0,r.useState)(0),2),se=ie[0],ue=ie[1],me=J((0,r.useState)(!1),2),fe=me[0],pe=me[1],ge=J((0,r.useState)(5),2),de=ge[0],he=ge[1],ye=function(){T((0,C.TS)(P,{messageOpen:!1}))},ve=function(){(0,C.uz)(j.list,{}).then((function(e){var t=e.items||[];X(t.length),W(t),T({messageOpen:!0,message:"查询成功",messageType:"success"})}))},be=function(e){var t=(0,C.d9)(I).concat(e);t.length>5&&t.splice(0,t.length-5),z(t)},Ee=function(e){return-1!==oe.indexOf(ke(e))},ke=function(e){var t=n.filter((function(e){return e.primary})).map((function(t){return e[t.key]}));return 0===t.length&&(t=e[n[0].key]),JSON.stringify(t)},Ze=de-Math.min(de,V-se*de),Se=I[I.length-1];return(0,r.useEffect)((function(){ve(),R((0,C.d9)((l||{}).uri||{})),q((0,C.d9)((l||{}).forms||[]))}),[l]),a().createElement("div",{className:t.root},a().createElement(o.Z,{open:P.messageOpen,anchorOrigin:{vertical:"top",horizontal:"center"},autoHideDuration:6e3,onClose:ye},a().createElement(S.Z,{onClose:ye,elevation:6,variant:"filled",severity:P.messageType},P.message||"ok")),a().createElement(c.Z,{open:O,onClose:function(){A(!1)},"aria-labelledby":"alert-dialog-title","aria-describedby":"alert-dialog-description"},a().createElement(i.Z,{id:"alert-dialog-title"},"注意！！！"),a().createElement(s.Z,null,a().createElement(u.Z,{id:"alert-dialog-description"},"确认删除吗？")),a().createElement(m.Z,null,a().createElement(f.Z,{onClick:function(){A(!1)},color:"primary"},"关闭"),a().createElement(f.Z,{onClick:function(){var e=F.filter((function(e){return Ee(e)}));e.length>0&&(0,C.uz)(j.delete,e).then((function(e){e.items.filter((function(e){for(var t=0;t<F.length;t++)if(ke(e)===ke(F[t])){F.splice(t,1);break}})),ce([]),A(!1),T({messageOpen:!0,message:"删除成功",messageType:"success"})}))},color:"secondary",autoFocus:!0},"确定"))),a().createElement(p.Z,{className:t.paper},a().createElement(B,{title:"用户",numSelected:oe.length,onSave:function(){q(L.map((function(e){var t=(0,C.d9)(e);return t.value=void 0,t}))),be(1)},onUpdate:function(){F.forEach((function(e){Ee(e)&&q(L.map((function(t){var n=(0,C.d9)(t);return n.value=e[t.key],n})))})),be(2)},onDelete:function(){A(!0)},onRefresh:ve,onShow:function(){var e;(e=(0,C.d9)(I)).length>0?(e.splice(e.length-1),z(e)):z([0])},onRelate:function(){F.forEach((function(e){Ee(e)&&q(L.map((function(t){var n=(0,C.d9)(t);return n.value=e[t.key],n})))})),be(3)}}),a().createElement(g.Z,null,a().createElement(d.Z,{className:t.table,"aria-labelledby":"tableTitle",size:fe?"medium":"small","aria-label":"enhanced table"},a().createElement(M,{headCells:n,numSelected:oe.length,order:ee,orderBy:re,onSelectAllClick:function(e){e.target.checked?ce(F.map((function(e){return ke(e)}))):ce([])},onRequestSort:function(e,t){var n=re===t&&ee===_.ASC;te(n?_.DESC:_.ASC),ae(t)},rowCount:F.length}),a().createElement(h.Z,null,F.sort((function(e,t){if(re&&ee){var n=(0,C.qu)(e[re],t[re]);return"asc"===ee?n:-1*n}return 0})).map((function(e,t){var r=Ee(e),l="enhanced-table-checkbox-".concat(t);return a().createElement(y.Z,{hover:!0,onClick:function(t){return function(e,t){var n=ke(t),r=oe.indexOf(n);ce(r<0?[n].concat(oe):oe.slice(0,r).concat(oe.slice(r+1)))}(0,e)},role:"checkbox",tabIndex:-1,"aria-checked":r,key:l,selected:r},n.map((function(n){var o=n.key;if(n.checkbox){var c=[];return c.push(a().createElement(v.Z,{key:"row-checkbox-"+t,padding:"checkbox"},a().createElement(b.Z,{checked:r,inputProps:{"aria-labelledby":l}}))),c.push(a().createElement(v.Z,{key:"row-"+o+"-"+t,component:"th",id:l,scope:"row",padding:"none"},e[o])),c}return a().createElement(v.Z,{key:"row-"+o+"-"+t,align:n.numeric?"right":"left"},e[o])})))})),Ze>0&&a().createElement(y.Z,{style:{height:(fe?33:53)*Ze}},a().createElement(v.Z,{colSpan:6}))))),a().createElement(E.Z,{component:"div",rowsPerPageOptions:[5,10,25],count:V,rowsPerPage:de,page:se,onRowsPerPageChange:function(e){he(parseInt(e.target.value,10)),ue(0)},onPageChange:function(e,t){ue(t)}})),a().createElement(k.Z,{control:a().createElement(Z.Z,{color:"default",checked:fe,onChange:function(e){pe(e.target.checked)}}),label:"大尺寸"}),L&&j.save&&j.update?a().createElement(H,{title:1===Se?"保存":"更新",submitUri:1===Se?j.save:j.update,forms:L,open:Se>0,onClose:function(){be(0)},onSuccess:function(e){var t=e.data,n=F.map((function(e){return Ee(e)?(!1,t):e}));1===Se?(n.push(t),T({messageOpen:!0,message:"保存成功",messageType:"success"})):T({messageOpen:!0,message:"更新成功",messageType:"success"}),W(n),be(0)},onError:function(e){be(0),T(1===Se?{messageOpen:!0,message:"保存失败",messageType:"error"}:{messageOpen:!0,message:"更新失败",messageType:"error"})}}):null)}},1398:function(e,t,n){"use strict";t.Z=n.p+"img/20220716/close.svg"},1432:function(e,t,n){"use strict";t.Z=n.p+"img/20220716/photo.svg"}}]);