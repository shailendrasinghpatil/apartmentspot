(function( $ ){
	eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('(q(e){q r(){G r=q(){9.K=!1,9.W={},9.Y=!1};9.2s=1,9.2t=2,9.2u=3,9.2v=4,9.2w=5;G i=[],s=n,o=s.2x.I(),u=/2y/1C.1a(o)&&/2z/1C.1a(s.2A),a=/2B/.1a(o),f=/2C/.1a(o),l={1b:2D,16:!1,17:!1},c=[],h=!1,p="X",d="",v=!0,m=[],g={},y="",b={},w=q(){G e=m.F,t,n;U(t=0;t<e;t++)n=m[t][0],v?n("X","",m[t][1]):n(p,d,m[t][1])},E=q(e,t){z t&&(e.1D?e.1D():e.2E=!0,e.1E?e.1E():e.2F=!1),!t};9.1F=q(t,n,r){6(V t!="2G")6(V t=="2H"){G i=e[t];6(V i!="q")1c"1d.1F(): 2I 1n 1o 1p";t=1e i}J t=1e t;r=r||[],r.F==0&&(r=t.2J());G s=r,o=0,u,a,f=t.2K();a=r.F;U(o=0;o<a;o++)u=r[o],t.2L(u)&&(g[u.I()+f.I()]=t);z n&&9.1q(n,f),t},9.2M=q(e,t){6(!e||!t)z;e=e.I(),t=t.I(),e==p&&d==t&&(v=!0,p="X",d="",w()),1f g[e.I()+t.I()]},9.1G=q(e){z v?e:g[p+d].1G(e)},9.1H=q(){z v?[]:g[p+d].1H()},9.1I=q(){z v?[]:g[p+d].1I()},9.1J=q(){z v?{1r:"X",2N:"",2O:!0}:g[p+d].1J()},9.1K=q(e,t,n){z v?e:g[p+d].1K(e,t,n)},9.2P=q(e,t,n){l={1b:e,17:!!t,16:!!n}},9.2Q=q(){z{2R:l.1b,17:l.17,16:l.16}},9.2S=q(){z v?{1r:"X",1L:""}:{1r:p,1L:d}},9.1M=q(){z v?"1N-X.1O":g[p+d].1M()},9.1P=q(){z v?"":g[p+d].1P()},9.1Q=q(e){6(e<1||e>7)e=1;z v?{2T:"1N-2U.1O",x:0,y:(e-1)*20}:g[p+d].1Q(e)},9.1q=q(e,t){e&&(e=e.I()),t&&(t=t.I()),e&&t&&g[e+t]?(g[e+t].1q(e),g[e+t].1g(),p=e,d=t,v=!1):v=!0,w()},9.1R=q(e,t,n){6(!e||V e!="q")1c"1d.1R(): 2V q 1n 1o 1p";n=!!n;G r=m.F,i,s=!1;6(!n){U(i=0;i<r;i++)m[i][0]==e&&m[i][1]==t&&(s=!0);s||(m[r]=[],m[r][0]=e,m[r][1]=t)}J U(i=0;i<r;i++)m[i][0]==e&&m[i][1]==t&&m.2W(i,1)},9.1S=q(e,t){G n=h?i[y]:i[e],r=u?t.1T:t.1U,s;6(V n=="1h")z!0;6(r==l.1b&&t.1V==l.17&&t.1W==l.16)p!="X"&&(v=!v,g[p+d].1g(),w());J 6(r>=37&&r<=2X||r==1X||r==8||r==13)v||g[p+d].1g();z!0},9.1Y=q(t,n){G r=h?i[y]:i[t],s,o=u?n.1T:n.1U,l,m,w,S="",x=0;6(V r=="1h"||v)z!0;G T=r.W,N=n.1s||n.1t;b!=N&&(b=N,g[p+d].1g());6(h){6(N.18.I()=="2Y"&&N.2Z.I()=="1i"||N.18.I()=="30")T=N,r.Y=r.K=!1;J 6(N.Z.1Z&&N.Z.1Z.I()=="31")r.K=!0,r.Y=!1,T=N.Z;J{6(N.18.I()!="21"||N.22!="23")z!0;r.Y=r.K=!0,T=N}6(c[T.Q]||c[T.24])z!0}r.K&&(T=h&&T.Q?i[T.Q].W:T,T.R?T=T.R:T.25&&(T=T.25));6(a&&(o==8||o==1X)&&r.K&&T.10){l=T.11(),m=l.26(0);6(m.27==T.10.32.33&&m.28==0)z E(n,!0)}s=g[p+d].34(o,n.1V,n.1W),S=s.35;6(!s.1u)z!0;x=-s.36;6(x==0&&S.F==0)z E(n,s.1u);w=T.10||T.Z||T,r.Y?l=e.11():l=T.11?T.11():w.11?w.11():w.38,m=l.39>0?l.26(0):l.1v?l.1v():w.1v();6(u&&!m.29)m.3a("3b",x),m.1i=m.1i.1w(m.1i.F-1)==" "?S+" ":S,m.2a(!0),m.3c();J 6(r.K){G C,k,L,A,O="",M="",1j=!1;C=m.27,k=m.3d,L=m.28,A=m.3e;6(C.2b==3)O=C.1k.1l(0,L+x),M=C.1k.1l(A),1j=!0;J{G D;T.1x?D=T.1x(S):D=w.1x(S),C.12.F>0&&C.12[L].2b==3?(D=C.12[L],O=D.1k,1j=!0):C.12.F>0&&C.12[L].18=="3f"?(C.3g(w.2c("p").1y(D),C.12[L]),L=S.F,A=S.F):(C.1y(w.2c("p").1y(D)),L=S.F,A=S.F),C=D,k=D}G P=L;1j&&(f&&O.F>=2&&O.1w(O.F-1)=="\\3h"&&O.1w(O.F-2)!=" "&&(O=O.3i(0,O.F-1)+" "),C.1k=O.1z()+S.1z()+M.1z(),P=L+x+S.F,P<0&&(P=0),C==k&&(A=P)),m.29(C,P),m.3j(k,A),m.3k(),m.2a(!0),l.3l(),l.3m(m)}J{G H=T.2d,B=T.2e,j=T.2f;V S!="1h"&&(S.F!=0||x!=0)&&(T.19=T.19.1l(0,T.2d+x)+S+T.19.1l(T.3n,T.19.F),H=H+S.F+x,H<0&&(H=0),T.3o(H,H),T.2e=B,T.2f=j)}z E(n,s.1u)},9.1A=q(t,n){G r=i[t];z u&&r.W.R?r.W.R.2g:e.2g||n};G S=q(e,t,n){t.14||(t.14=q(e){G n=e.1s||e.1t;z n=n.Q||n.Z.Q,e=t.1A(n,e),t.1Y(n,e)}),t.15||(t.15=q(e){G n=e.1s||e.1t;z n=n.Q||n.Z.Q,e=t.1A(n,e),t.1S(n,e)});G r=i[e].W;r.R?r=r.R.10:r.2h&&(r=r.2h),a?n?(r.2i("2j",t.14,!0),r.2i("2k",t.15,!0)):(r.2l("2j",t.14,!0),r.2l("2k",t.15,!0)):n?(r.2m("2n",t.14),r.2m("2o",t.15)):(r.2p("2n",t.14),r.2p("2o",t.15))};9.1m=q(e,n,s,o){6(V o=="1h"||o==1B)o=!0;6(e||n){6(!n){6(!e)1c"1d.1m(): 3p 19 3q U 3r 2q 3s 3t";n=t.3u(e);6(u){G a=t.3v[e],f=0;6(a)6(a.F){U(f=0;f<a.F;f++)6(a[f].24==e){n=a[f];3w}}J n=a;J n=1B}6(!n)1c"1d.1m(): 2q 1n 1o 1p"}e||(e="3x"+i.F),i[e]=1e r;G l=i[e];z l.W=n,l.K=n.R?!0:!1,n.18.I()=="21"&&n.22=="23"&&(l.K=!0,l.Y=!0),l.K&&n.R?n.R.10.Q=e:n.Q=e,o&&S(e,9,!1),e}s||(s=""),h=!0;G p=s.3y(","),f=0,d="";U(f=0;f<p.F;f++)d=p[f],d!=""&&(c[d]=!0);z y=9.1m(1B,t),y},9.3z=q(e){6(e){6(!i[e])z;S(e,9,!0),1f i[e]}J{6(!h)z;h=!1,S(y,9,!0),1f i[y];G t;U(t 3A c)1f c[t]}}}G t=e.10,n=e.3B;e.2r=e.2r||1e r})(3C);',62,225,'||||||if|||this|||||||||||||||||function|||||||||return||||||length|var||toLowerCase|else|isIFrame||||||_pramukhId|contentWindow|||for|typeof|elementObject|english|isDiv|ownerDocument|document|getSelection|childNodes||kblistener|kbposition|alt|ctrl|nodeName|value|test|code|throw|PramukhIME|new|delete|reset|undefined|text|_|nodeValue|substring|enable|is|not|valid|setLanguage|language|target|srcElement|letterConsumed|createRange|charAt|createTextNode|appendChild|toString|getEventObject|null|gi|stopPropagation|preventDefault|addLanguage|rectify|getChars|getExamples|getConversionLanguage|convert|kb|getHelpImage|pramukhime|png|getHelp|getIcon|onLanguageChange|onKeydown|keyCode|which|ctrlKey|altKey|46|onKeypress|designMode||div|contentEditable|true|id|defaultView|getRangeAt|startContainer|startOffset|setStart|collapse|nodeType|createElement|selectionStart|scrollTop|scrollLeft|event|contentDocument|removeEventListener|keypress|keydown|addEventListener|detachEvent|onkeypress|onkeydown|attachEvent|ElementName|pramukhIME|LANGUAGE_ICON|LANGUAGE_CONVERSION_ICON|LANGUAGE_CLICK_ICON|LANGUAGE_HELP_ICON|SCRIPT_CONVERSION_ICON|userAgent|msie|Explorer|appName|gecko|webkit|120|cancelBubble|returnValue|object|string|KeyboardPlugin|getLanguages|getKBName|supports|removeLanguage|preferredFont|reverseConversionSupported|setToggleKey|getToggleKey|key|getLanguage|iconFile|icon|Callback|splice|40|input|type|textarea|on|body|firstChild|process|unicodeText|removeCharacters||selection|rangeCount|moveStart|character|select|endContainer|endOffset|BR|insertBefore|u00a0|substr|setEnd|deleteContents|removeAllRanges|addRange|selectionEnd|setSelectionRange|No|found|argument|or|ElementObject|getElementById|all|break|pramukhime_|split|disable|in|navigator|window'.split('|'),0,{}));
	eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('1c 8W(e){1f t="",n={},r={},i={},s={},o=0,u=!1,a,f,l,c,h,p,d={},v={},m=gC,g=32,y=!1,b=!1,w=!1,E=!1,S=!1,x="",T="",N=0,C=!1,k=1c(){1f e=n,t=r;Z(e,{65:e[4o],73:e[3M],85:e[4g],8U:e[4s],9G:e[5g],5f:e[4W],82:e[4C],3v:e[2G],83:e[8L]}),Z(t,{72:t[58],65:t[4o],73:t[3M],85:t[4g],8U:t[4s]})},L=1c(){1f e=n,t=r,o=i,u=s,a,f;1j(a 1z u)24 u[a];Z(u,e),Z(u,t),Z(u,o);1j(a 1z e)u[e[a]]=a;1j(a 1z t)u[t[a]]=a;1j(a 1z o)u[o[a]]=a},A=1c(){1f e=n,t=s;M(),e[4C]="\\2P",e[2G]="\\1Y",e[3v]="\\1Y",t["\\2P"]="4C",t["\\1Y"]="2G",h="\\2X-\\3Z,\\3s,\\4j,\\3l,\\6L-\\6I,\\6G-\\6F,\\6E-\\7k,\\2P,\\6w,\\1Y,\\6r-\\4B,\\4D\\27\\6o,\\5Q\\27\\5K,\\4q,\\3m-\\5F,\\3U,\\2v,\\2K-\\6m,\\4M-\\4R,\\2I-\\4U,\\3p-\\3n,\\3b,\\4r-\\4e,\\27,\\2B-\\4V,\\4c,\\4Y,\\4a-\\5b,\\5k-\\5m",p="ba\'gx,gu~,gs,gr,fT,fS,2z,3T^n"},O=1c(){1f e=n,t=i,r=s;M(),e[2G]="\\1Y",e[3v]="\\1Y",r["\\1Y"]="2G",24 t[39],24 t[fQ],h="\\2X-\\3Z,\\3s,\\4j,\\3l,\\6L-\\6I,\\6G-\\6F,\\6E-\\9c,\\6w,\\6r-\\4B,\\4D\\27\\6o,\\5Q\\27\\5K,\\4q,\\3m-\\5F,\\3U,\\2P-\\1Y,\\2K-\\6m,\\4M-\\4R,\\2I-\\4U,\\3p-\\3n,\\3b,\\4r-\\4e,\\27,\\2B-\\4V,\\4c,\\4Y,\\4a-\\5b,\\5k-\\5m",p="fK*aa,fI,2x,99,33,93^^m,2z,3T^n"},M=1c(){1f e=n,t=r,s=d,o=i;a=/[\\4D-\\4B\\3m-\\3U\\2P-\\1Y]/,f=/[\\2X-\\fD\\3s-\\3l]/,l=/[\\4r-\\4e]/,c=/[\\2B]/,h="\\2X-\\3Z,\\3s,\\4j,\\3l,\\6L-\\6I,\\6G-\\6F,\\6E-\\9c,\\6w,\\6r-\\4B,\\4D\\27\\6o,\\5Q\\27\\5K,\\4q,\\3m-\\5F,\\3U,\\2P-\\1Y,\\2v,\\2K-\\6m,\\4M-\\4R,\\2I-\\4U,\\3p-\\3n,\\3b,\\4r-\\4e,\\27,\\2B-\\4V,\\4c,\\4Y,\\4a-\\5b,\\5k-\\5m",p="5E,3k,2x,99,33,93^^m,2z,3T^n",et(e,"69,79,2G".1b(",")),et(t,"69,79".1b(",")),et(o,"2j".1b(",")),Z(e,{5M:"\\4c"}),Z(t,{4z:"\\3b"}),Y(o,"5T,fC,4F,8r,8l,fB,8k,fA".1b(","),"\\4a"),Z(o,{fz:"\\4q",63:"~",4I:"*",39:"\\2v",6b:"\'"}),Y(s,"\\fy\\2B,\\fx\\2B,,\\7k\\2B".1b(","),"\\3m"),L(),k(),Z(e,{76:e[a5]}),Z(v,{"\\2X\\2K":"\\7y","\\3Z\\fw":"\\3s","\\4j\\4M":"\\3l","\\2X\\2K":"\\7y","\\2I\\2K":"\\3p","\\2K\\2I":"\\3p","\\2I\\3b":"\\3n","\\3b\\2I":"\\3n"})},1N=1c(){1f e=n,t=r,s=d,o=i;h="\\1l-\\2H,\\1R,\\2F,\\1S,\\1T-\\2V,\\1F-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\2v,\\1i-\\2L,\\2t-\\2l,\\1w-\\1P,\\1V-\\1I,\\26-\\1W,\\11,\\1d,\\2f-\\2o,\\2a,\\2b,\\1C,\\29-\\2d",p="ft,fq\'fp,fo,fn,fm",et(e,"69,79".1b(",")),et(t,"69,79".1b(",")),o[64]="\\1C",o[39]="\\2v",o[6b]="\'",R()},D=1c(){1f e=n,t=r,s=d,o=i;h="\\1l-\\2H,\\1R,\\2F,\\1S,\\1T-\\2V,\\1F-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\2v,\\1i-\\2L,\\2t-\\2l,\\1w-\\1P,\\1V-\\1I,\\26-\\1W,\\11,\\1d,\\2f-\\2o,\\2a,\\2b,\\29-\\2d",p="fl,fk,fj,fi,ba\'fh",et(e,"69,79".1b(",")),et(t,"69,79".1b(",")),o[39]="\\2v",o[6b]="\'",R(),24 o[6C]},P=1c(){D(),p="fg,ff~,fe,fd,fc,fb,fa~f9"},H=1c(){1f e=n,t=r,s=d,o=i;h="\\1l-\\7x,\\1T-\\2V,\\1F-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\1i-\\f8,\\1w-\\1P,\\1V-\\1I,\\26-\\1W,\\11,\\1d,\\2a,\\2b,\\1C,\\29-\\2d",p="3W,3k,2x,33,2z,3X,7z^^30,7H*7O,43,6a*30,67,u@66@",et(e,"23,22,2p,2h,69,79".1b(",")),et(t,"23,22,2p,2h,69,79,35,8a,36,8v".1b(",")),o[64]="\\1C",R()},B=1c(){q(),p="f7,f4,f2,f1,eW*30,eV"},j=1c(){1f e=n,t=r,s=d,o=i;h="\\1l-\\2H,\\1R,\\2F,\\1S,\\1T-\\2V,\\1F-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\1i-\\2L,\\2t-\\2l,\\1w-\\1P,\\1V-\\1I,\\26-\\1W,\\11,\\1d,\\2f-\\2o,\\2a,\\2b,\\1C-\\3j,\\29-\\2d",p="eU,eT,eS,eQ*eO,eM,eL~,eK,eJ",et(e,"69,79".1b(",")),et(t,"69,79".1b(",")),o[64]="\\1C",o[9l]="\\3j",R()},F=1c(){1f e=n,t=r,s=d,o=i;h="\\1l-\\2H,\\1R,\\2F,\\1S,\\1T-\\2V,\\1F-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\1i-\\2L,\\2t-\\2l,\\1w-\\1P,\\1V-\\1I,\\26-\\1W,\\11,\\1d,\\2f-\\2o,\\2a,\\2b,\\29-\\2d",p="eI,eH,eD,9N,eC,eB:,eA,ev",et(e,"69,79".1b(",")),et(t,"69,79".1b(",")),R(),u=!0},I=1c(){1f e=n,t=r,s=d,o=i;h="\\1l,\\2N,\\4J,\\2M-\\2H,\\1R,\\2F,\\1S,\\9T-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\1i-\\2L,\\2t-\\2l,\\1O-\\1I,\\26-\\1W,\\11,\\1d,\\2f-\\2o,\\2a,\\2b,\\1C-\\3j,\\29-\\2d",p="eu,es*,g~er,b~eq,ep,en",et(e,"69,79".1b(",")),et(t,"69,79,3H,58".1b(",")),o[64]="\\1C",Z(e,{em:"\\el",ej:"\\eh",eg:"\\ef",ed:"\\4Z"}),R()},q=1c(){1f e=n,t=i;h="\\1l-\\2H,\\1R,\\2F,\\1S,\\2N,\\1T-\\2O,\\1F-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\1i-\\2L,\\2t-\\2l,\\1O,\\1w-\\3G,\\1V-\\1I,\\26-\\1W,\\11,\\1d,\\2f-\\2o,\\2a,\\2b,\\1C,\\29-\\2d",p="3W,ec,3k,2x,33,2z,3T^^n,3X,43,6a*30,67,u@66@",e[69]="\\2N",t[64]="\\1C",R()},R=1c(){1f e=n,t=r,s=d,o=i;a=/[\\1u-\\1Q\\1v-\\1x\\9M-\\4Z]/,f=/[\\4J-\\2Z\\1R-\\1S\\2N-\\9L]/,l=/[\\9K-\\1W]/,c=/[\\1d]/,Z(t,{36:"\\2f",8v:"\\eb",35:"\\ea",8a:"\\2o"}),Z(o,{e9:"$",6C:"@",9D:"#",4I:"*"}),s["\\1u\\1d"]="\\1v",s["\\5j\\1d"]="\\9y",s["\\5l\\1d"]="\\9x",s["\\1A\\1d"]="\\9t",s["\\5o\\1d"]="\\9m",s["\\5q\\1d"]="\\1L",s["\\5r\\1d"]="\\1Z",s["\\5s\\1d"]="\\1x",s["\\1E\\1d"]="\\1G",s["\\1B\\1d"]="\\1H",s["\\1D\\1d"]="\\1M",s["\\1u\\11\\1d\\11"]="\\1v\\11",s["\\5j\\11\\1d\\11"]="\\9y\\11",s["\\5l\\11\\1d\\11"]="\\9x\\11",s["\\1A\\11\\1d\\11"]="\\9t\\11",s["\\5o\\11\\1d\\11"]="\\9m\\11",s["\\5q\\11\\1d\\11"]="\\1L\\11",s["\\5r\\11\\1d\\11"]="\\1Z\\11",s["\\5s\\11\\1d\\11"]="\\1x\\11",s["\\1E\\11\\1d\\11"]="\\1G\\11",s["\\1B\\11\\1d\\11"]="\\1H\\11",s["\\1D\\11\\1d\\11"]="\\1M\\11",L(),k(),Z(v,{"\\1l\\2E":"\\4J","\\1l\\1i":"\\2M","\\e8\\e7":"\\7x","\\1T\\1O":"\\9T","\\1T\\2E":"\\e6","\\1T\\1w":"\\2V","\\1l\\3G":"\\2O","\\1l\\1i\\1O":"\\2O","\\1l\\1O\\1i":"\\2O","\\2M\\1O":"\\2O","\\1l\\5x":"\\4w","\\1l\\1i\\2E":"\\4w","\\1l\\2E\\1i":"\\4w","\\2M\\2E":"\\4w","\\1l\\1V":"\\1F","\\1l\\1i\\1w":"\\1F","\\1l\\1w\\1i":"\\1F","\\2M\\1w":"\\1F","\\1l\\1I":"\\2Z","\\1l\\1i\\1P":"\\2Z","\\1l\\1P\\1i":"\\2Z","\\2M\\1P":"\\2Z","\\1l\\1O":"\\2N","\\1B\\11\\2D":"\\1H\\11","\\1i\\1O":"\\3G","\\1O\\1i":"\\3G","\\1i\\2E":"\\5x","\\2E\\1i":"\\5x","\\1i\\1w":"\\1V","\\1w\\1i":"\\1V","\\1i\\1P":"\\1I","\\1P\\1i":"\\1I"})},U=1c(){1f e=n,t=r,s=d,o=i;a=/[\\1u-\\1Q\\1v-\\1x\\9M-\\4Z]/,f=/[\\4J-\\2Z\\1R-\\1S\\2N-\\9L]/,l=/[\\9K-\\1W]/,c=/[\\1d]/,h="\\1l-\\2H,\\1R,\\2F,\\1S,\\1T-\\2O,\\1F-\\1E,\\2g-\\1B,\\2c,\\2e-\\1Q,\\1D,\\1u\\11\\28,\\1A\\11\\25,\\1v-\\1L,\\1G,\\1Z-\\1x,\\1H,\\1M,\\1i-\\2L,\\2t-\\2l,\\1O,\\1w-\\3G,\\1V-\\1I,\\26-\\1W,\\11,\\1d,\\2f-\\2o,\\2a,\\2b,\\1C-\\3j,\\29-\\2d",p="3W,3k,2x,33,2z,3X,7z^^30,7H*7O,43,6a*30,67,u@66@",Z(o,{64:"\\1C",9l:"\\3j"}),Y(s,"\\1u\\1d,\\5j\\1d,\\5l\\1d,\\1A\\1d,\\5o\\1d,\\5q\\1d,\\5r\\1d,\\5s\\1d".1b(","),"\\1v"),Y(s,"\\1E\\1d,,,,,,,,\\1B\\1d,,,\\1D\\1d".1b(","),"\\1G"),R()},z=1c(){1f e=i,t=n,s=r;a=/[\\92-\\8V]/,f=/[\\1t-\\3d\\5G-\\8S]/,l=/[\\8R-\\8P]/,c=/[\\8O]/,h="\\1t-\\8M,\\5G,\\e5,\\8S,\\5N,\\5O-\\3f,\\37-\\e3,\\e2-\\e1,\\dZ-\\dY,\\dW-\\8V,\\92\\4Q\\dV,\\dU\\4Q\\dT,\\1r-\\8e,\\dS-\\dR,\\2C,\\2A-\\46,\\45-\\44,\\8R-\\8P,\\4Q,\\8O,\\dQ,\\dP,\\7Z,\\dO-\\dN",p="3W,5E,3k,2x,33,2z,3X,43,dM,an^n,dL^^dK,dJ^^",et(t,"23,22"),et(s,"23,22"),Z(t,{7F:"\\8M",7C:"\\5G"}),Z(s,{7F:"\\dI",7C:"\\8e"}),Z(e,{5T:"\\7Z",4I:"*"}),L(),k(),Z(v,{"\\1t\\1r":"\\3Y","\\1t\\2C":"\\5N","\\1t\\2A":"\\5O","\\1t\\2Y":"\\7m","\\1t\\46":"\\3f","\\1t\\1r\\2C":"\\3f","\\1t\\2C\\1r":"\\3f","\\3Y\\2C":"\\3f","\\5N\\1r":"\\3f","\\1t\\45":"\\37","\\1t\\1r\\2A":"\\37","\\1t\\2A\\1r":"\\37","\\3Y\\2A":"\\37","\\5O\\1r":"\\37","\\1t\\44":"\\3d","\\1t\\1r\\2Y":"\\3d","\\1t\\2Y\\1r":"\\3d","\\3Y\\2Y":"\\3d","\\7m\\1r":"\\3d","\\2C\\1r":"\\46","\\1r\\2C":"\\46","\\2A\\1r":"\\45","\\1r\\2A":"\\45","\\2Y\\1r":"\\44","\\1r\\2Y":"\\44"})},W=1c(){1f e=n,t=r,s=d,o=i;a=/[\\dH-\\7l\\6s-\\6t]/,f=/[\\dG-\\dF\\2U-\\3C]/,l=/[\\dE-\\7j\\6A-\\6B]/,c=/[\\2i]/,h="\\dD-\\7h,\\2U,\\7g-\\7f,\\3C,\\7e-\\dC,\\dA-\\dy,\\dx-\\dw,\\6R,\\dv,\\6N-\\7l,\\6s-\\6O,\\6t,\\6P,\\6Q,\\du-\\6S,\\6T-\\dt,\\ds-\\dr,\\6A-\\6B,\\dq-\\7j,\\dp,\\2i,\\6Y,\\6Z,\\71,\\74,\\do-\\dn",p="dm,dl,dk,aM~dj,di,dh",et(e,"23,22,2h,2p,69,79,76,7i,6z".1b(",")),et(t,"23,22,2h,2p,69,79".1b(",")),Z(o,{38:"\\74",2j:"\\71",9D:"#"}),Z(e,{4x:"\\6O",dg:"\\2U",df:"\\3C"}),Z(t,{de:"\\6A",7n:"\\6B",da:"\\6Y",35:"\\6Z"}),Z(s,{"\\d9\\2i":"\\6s","\\d8\\2i":"\\d7","\\d6\\2i":"\\d5","\\d4\\2i":"\\6t","\\6R\\2i":"\\6P","\\6N\\2i":"\\6Q"}),L(),k(),Z(v,{"\\2U\\d3":"\\7h","\\2U\\d2":"\\d0","\\2U\\6T":"\\7e","\\3C\\cZ":"\\7g","\\3C\\6S":"\\7f"})},X=1c(){1f e=n,t=r,s=i;a=/[\\7A-\\7B\\6k]/,f=/[\\7D-\\7E\\6j\\7G]/,l=/[\\cX-\\7I]/,c=/[\\7J]/,h="\\7D-\\7K,\\6j,\\cW,\\7G,\\7M-\\cR,\\6g-\\cQ,\\cP-\\cO,\\cN,\\cM-\\7B,\\cL,\\7A\\3I\\cv\\3I,\\cu\\3I\\cr\\3I,\\7X,\\6k,\\7Y-\\cq,\\cp-\\co,\\2r,\\2u-\\4P,\\4H,\\62,\\2Q-\\8c,\\cn-\\7I,\\3I,\\7J-\\cm,\\8f-\\8g,\\cf-\\ce",p="8j,cd,9N,c9,c3,c1,bX,bV^^bU",u=!0,et(t,"3H".1b(",")),et(s,"2j".1b(",")),Z(e,{69:"\\bT",1U:"\\7M",79:"\\bS",1X:"\\6g",4x:"\\7X",70:"\\6k"}),Z(t,{69:"\\4P",1U:"\\2u",79:"\\5V",1X:"\\2Q",bR:"\\2r",5U:"\\4H"}),Z(s,{bQ:"\\8f",8k:"\\8g"}),L(),k(),Z(v,{"\\6g\\8c":"\\7E","\\7K\\7Y":"\\6j","\\8y\\2r":"\\8z","\\2r\\8y":"\\8z","\\2u\\2r":"\\4P","\\2r\\2u":"\\4P","\\2u\\4H":"\\62","\\4H\\2u":"\\62","\\2u\\8A":"\\2Q","\\8A\\2u":"\\2Q","\\2Q\\2r":"\\5V","\\2r\\2Q":"\\5V"})},V=1c(){1f e=n,t=r,s=i,o=d;a=/[\\5R-\\bO\\4A-\\8D]/,f=/[\\8E-\\8F\\8G-\\8H]/,l=/[\\8I-\\8J]/,c=/[\\bN]/,h="\\8E-\\bM,\\8G,\\bL,\\8H,\\5L-\\8N,\\4t-\\5J,\\bK-\\5I,\\5H,\\bJ-\\bI,\\5D,\\5R\\1s\\bH\\1s,\\bG\\1s\\bF\\1s,\\8Z,\\91,\\4A-\\8D,\\3a-\\bE,\\bD-\\bC,\\2w-\\bB,\\4d-\\3V,\\2y,\\5z,\\8I-\\8J,\\1s,\\bA,\\9g-\\bz,\\br,\\bm-\\bl",p="9k,8j,bi,bg,bf*b4",u=!0,et(t,"3H,42".1b(",")),et(s,"2j".1b(",")),Z(e,{69:"\\b2",1U:"\\5L",79:"\\9r",1X:"\\4t",4x:"\\8Z",aZ:"\\91"}),Z(t,{69:"\\5n",1U:"\\2w",79:"\\3V",1X:"\\4d",4z:"\\2y"}),Y(s,"9u,9v,4F,aY,aX,aV,,,,aS".1b(","),"\\9g"),s[42]="*",Y(o,"\\9z\\1s*,\\5J\\1s*,\\5I\\1s*,\\5H\\1s*,\\5D\\1s*,\\5R\\1s*".1b(","),"\\4A"),L(),k(),Z(v,{"\\aQ\\2y":"\\aP","\\aN\\2y":"\\aF","\\5L\\2w":"\\8N","\\4t\\3a":"\\9r","\\4t\\2y":"\\8F","\\2w\\3a":"\\4d","\\3a\\2w":"\\4d","\\5n\\3a":"\\3V","\\3a\\5n":"\\3V","\\2w\\2y":"\\5z","\\2y\\2w":"\\5z","\\9z\\1s\\2D":"\\4A","\\5J\\1s\\2D":"\\aD","\\5I\\1s\\2D":"\\aC","\\5H\\1s\\2D":"\\aA","\\5D\\1s\\2D":"\\ay"})},$=1c(){1f e=n,t=r,o=i,u=d,m=s;a=/[\\9I-\\9J\\5e-\\5d\\47]/,f=/[\\5a-\\9O-\\9P\\9Q]/,l=/[\\9R-\\9S]/,c=/[\\4b]/,h="\\5a-\\ax,\\9P,\\aw,\\9Q,\\9W-\\9X,\\9Y-\\av,\\au-\\aj,\\ag,\\af-\\9J,\\ae,\\9I\\4S\\ad,\\ac\\4S\\a7,\\5e-\\gF,\\5d,\\47,\\4f-\\a8,\\a9-\\ab,\\2J,\\4E,\\4T,\\3r,\\3u,\\ah,\\9R-\\9S,\\4S,\\4b-\\ai,\\a0,\\ak-\\al",p="5E,am,ao^,ap*aq",et(e,"69,79".1b(",")),et(t,"69,79".1b(",")),et(o,"2j".1b(",")),Y(t,"5U,4z".1b(","),"\\4E"),Z(e,{89:"\\5d",5M:"\\a0"}),Y(u,"\\ar\\4b,\\as\\4b".1b(","),"\\5e"),Z(o,{4I:"*",63:"~"}),L(),k(),Z(e,{3v:"\\47"}),Z(m,{"\\47":"3v"}),Z(v,{"\\5a\\4f":"\\at","\\9W\\3u":"\\9X","\\9Y\\3u":"\\9O","\\2J\\4E":"\\4T","\\4E\\2J":"\\4T","\\2J\\4f":"\\3r","\\4f\\2J":"\\3r","\\2J\\3u":"\\3r","\\3u\\2J":"\\3r"})},J=1c(){1f e=n,t=r,o=i,d=s;a=/[\\4X-\\9V]/,f=/[\\9U-\\9H]/,l=/[\\az-\\5h]/,c=/[\\aB]/,h="\\9U-\\9F,\\9E-\\aE,\\5i-\\4X,\\aG-\\aH,\\aJ,\\aK-\\aL,\\9C-\\aO,\\9B-\\9A,\\aR-\\9V,\\3x-\\aT,\\2W-\\aW,\\2T-\\4L,\\2R,\\b0,\\b1-\\5h,\\9q,\\b3,\\9o-\\b5,\\b6-\\b7",p="b8,b9,bb,bc,bd",u=!0,et(t,"3H,23,22,2h,2p,42".1b(",")),et(e,"23,22,9n,5f,4W,5p,bh,2h,2p,38,5t".1b(",")),et(o,"38,5t".1b(",")),Z(e,{69:"\\bj",1U:"\\9E",79:"\\bk",1X:"\\5i",78:"\\9C",9i:"\\9B",7n:"\\bn",bo:"\\bp",5p:"\\4X\\9q\\bq"}),Z(t,{69:"\\5y",1U:"\\2W",79:"\\4L",1X:"\\2T",4z:"\\2R"}),Y(o,"9u,9v,4F,bs,bt,bu,bv,bw,bx,5T,by".1b(","),"\\9o"),L(),k(),Z(e,{9h:e[3R],9a:e[3R],96:e[3R],95:e[84],68:e[84],8Y:e[84],8X:e[4k],4l:e[4k],8Q:e[4k],5g:e[4y],98:e[4y],8K:e[4y],82:"\\8C",9G:"\\5h\\9A"}),Z(d,{"\\8C":"82"}),Z(v,{"\\5i\\2R":"\\9H","\\bP\\2R":"\\9F","\\2W\\3x":"\\2T","\\3x\\2W":"\\2T","\\5y\\3x":"\\4L","\\3x\\5y":"\\4L","\\2W\\2R":"\\2T","\\2R\\2W":"\\2T"})},K=1c(){1f e=n,t=r,s=i;a=/[\\8w-\\8u]/,f=/[\\8s-\\8q\\8p\\8o]/,l=/[\\bW-\\8n]/,c=/[\\bY]/,h="\\8s-\\bZ,\\8p,\\c0,\\8o,\\8m-\\c2,\\5Z-\\c4,\\c5-\\c6,\\c7-\\8u,\\c8,\\8w\\3B\\ca\\3B,\\cb\\3B\\cc\\3B,\\2S,\\8i-\\8h,\\cg-\\ci,\\ck-\\cl,\\3F-\\61,\\81,\\80,\\6d-\\7W,\\cs-\\8n,\\3B,\\ct,\\7V-\\7U,\\cw-\\cx",p="9k,cy,cz,2x,cA,cB^cC",u=!0,et(t,"42".1b(",")),et(s,"2j".1b(",")),Y(t,"1U,69,,,1X,79,,,,,,,,,,5M,5U".1b(","),"\\3F"),Z(e,{4x:"\\cD"}),Y(e,"1U,69,,,1X,79".1b(","),"\\8m"),Z(s,{cE:"\\8i",cF:"\\8h",64:"\\7U",63:"~",6C:"@"}),Y(s,"cG,4F,8r,8l,cH,cI,cJ,64".1b(","),"\\7V"),L(),k(),Z(v,{"\\5Z\\2S":"\\cK","\\5Z\\7W":"\\8q","\\3F\\2S":"\\61","\\2S\\3F":"\\61","\\6d\\2S":"\\7S","\\2S\\6d":"\\7S","\\3F\\81":"\\80"})},Q=1c(){1f e=n,t=r,s=d,a=i,f=v;u=!1;1f l,c="";1j(l 1z e)24 e[l];1j(l 1z t)24 t[l];1j(l 1z s)24 s[l];1j(l 1z a)24 a[l];1j(l 1z f)24 f[l];Y(t,"3H,77,58".1b(","),"\\26"),Y(e,"97,4o,7Q,3M,7P,4g,23,2h,69,,1U,7N,79,,1X,4s,3R,9h,9a,96,cS,cT,9n,cU,4W,cV,84,95,68,8Y,78,4k,8X,4l,8Q,9i,,4y,5g,98,8K,7L,6h,4C,,a5,76,,2G,8L,7i,cY,4K".1b(","),"\\1l"),Z(e,{5p:"\\1u\\11\\28",6z:"\\1A\\11\\25",22:"\\1R",2p:"\\1S"}),Y(t,("42,,4o,7Q,3M,7P,4g,23,22,69,,1U,7N,79,,1X,4s,"+m).1b(","),"\\1d"),Z(t,{2h:"\\2t",2p:"\\2l"}),Z(a,{38:"\\2b",2j:"\\2a"}),Y(a,"48,49,50,51,52,53,54,55,56,57".1b(","),"\\29"),G(e,o),G(t,o),G(a,o),Z(t,{97:""}),Y(e,"d1,94".1b(","),"\\7w"),Z(a,{7v:"\\7u",7t:"\\7s",7r:"\\7q",7p:"\\7o",db:"|",dc:"^",dd:":",5t:"&"})},G=1c(e,t){1p(t==0)1o;1f n=0,r,i=34.3c,s,o;1j(s 1z e){o="",r=e[s].1k;1j(n=0;n<r;n++)o+=i(e[s].3e(n)+t);e[s]=o}},Y=1c(e,t,n){1f r=n.3e(0),i=0,s=0,o=t.1k,u=34.3c;1j(s=0;s<o;s++)t[s]!=""&&(e[t[s]]=u(r)),r++},Z=1c(e,t){1f n;1j(n 1z t)e[n]=t[n]},et=1c(e,t){1f n,r=t.1k;1j(n=0;n<r;n++)24 e[t[n]]};1g.6H=1c(e){1p(!1g.3i(e))3J"8W.6H(): 3z "+e+" 75 6X 6W.";1p(t==e.3A())1o;t=e.3A();1f n;3Q(t){1a"6M":o=3D,n=A;1h;1a"6K":o=3D,n=O;1h;1a"6J":o=3D,n=M;1h;1a"2s":o=dB,n=z;1h;1a"3K":n=U,o=0;1h;1a"6D":n=q,o=0;1h;1a"6y":n=1N,o=0;1h;1a"6v":n=D,o=0;1h;1a"6u":n=P,o=0;1h;1a"6q":n=H,o=0;1h;1a"6l":n=B,o=0;1h;1a"6i":n=j,o=0;1h;1a"40":n=I,o=0;1h;1a"41":n=F,o=0;1h;1a"6f":n=V,o=7R;1h;1a"6e":n=W,o=7T;1h;1a"6c":n=K,o=88;1h;1a"3t":n=X,o=8d;1h;1a"5Y":n=J,o=8t;1h;1a"5W":n=$,o=8x}Q(),n()},1g.dX=1c(){1f e=[],t,n,r,i,s,o=34.3c,u=h.1b(",");i=u.1k;1j(r=0;r<i;r++){s=u[r].1b("-");1p(s.1k==1)e.1e(s[0]);4h{n=s[1].3e(0);1j(t=s[0].3e(0);t<=n;t++)e.1e(o(t))}}1o e.1e("\\7u"),e.1e("\\7s"),e.1e("\\7q"),e.1e("\\7o"),e.1e("\\7w"),e.1e("\\2D"),e},1g.e0=1c(){1o 1g.31(p,"3o",t).1b(",")},1g.8B=1c(e,s,o){s=!!s,o=!!o;1p(e<32||e>=e4||s||o)1o 1g.4n(),{5w:!1,5v:0,5u:""};1f a=0,f="",l="",c="",h="",p="",v="",k="",L="",A=!0,O="",M=!1,1N=!1,D=!1,P=!1,H=!1,B=!1,j=!1,F=!1,I=!1,q=!1,R=n,U=r,z=d,W=i,X,V=!1;l=34.3c(e),O=34.3c(g),c=R[g.1y()+e.1y()],h=U[g.1y()+e.1y()],p=R[e.1y()],v=U[e.1y()],k=W[e.1y()],L=W[g.1y()+e.1y()],M=1J p!="1K",1N=1J v!="1K",D=1J k!="1K",P=1J L!="1K",H=1J c!="1K",B=1J h!="1K",j=u,F=E,I=S,q=y,w=b,b=y;3Q(l){1a"a":1a"e":1a"i":1a"o":1a"u":1a"A":1a"I":1a"U":1a"O":1a"E":P?(a-=x.1k,f=L):D?(a-=x.1k,f=k):B&&I?(O!="a"&&(!q||j)&&(a-=x.1k),j&&O=="R"&&(l=="i"||l=="I")&&a--,f=h,e=32,S=F,y=!1):H?(j&&I&&O=="R"&&(l=="i"||l=="I")&&a--,a-=x.1k,f=c,e=32,S=F,y=!1):F&&!q?(j&&a--,f=1N?v:"",O=="L"?l=="i"?e=13:l=="I"?e=12:t=="2s"&&l=="u"?e=13:t=="2s"&&l=="U"?e=12:S=F:S=F,y=f==""):M?(f=p,S=F,y=!1):(S=F,y=!0),E=!1;1h;1a"^":!F&&O!="^"?l="":H?(a--,f=c):f=(j?"":U[m])+p,S=F,E=!1,y=f=="";1h;1a" ":A=!1,j||(l=""),S=F,E=!1,y=!1;1h;1a"~":S=F,E=!1,y=!1,g!=4K&&g!=14||!I?P?(g==17?t!="3t"&&a--:g==72&&(e=17),a-=x.1k,f=L,E=!1):D?(f=k,E=!1):B&&(I||g==77||g==78||g==7L||g==6h)?(g!=78&&g!=6h||!I?g>=12&&g<=13&&(a-=2):a--,a--,f=h,e=32):H?(g>=12&&g<=13?a--:F&&(E=!0),a-=x.1k,f=c+(j&&F?U[m]:""),e=32):M?f=p:1N?(F&&j&&a--,f=v):f=l.1y():(C?(a-=x.1k,f=T+(!j&&!w?U[m]:"")+R[4K]+(j?U[m]:"")):(a=0,f=""),e=g,E=!0);1h;1a"*":1N&&F&&!q?j?(a--,f=v+U[m]):f=v:f=l.1y(),y=!1;1h;ei:S=F,P?(a-=x.1k,O=="R"&&l=="s"&&(e=16),f=L,E=!1):D?(O=="1"&&l=="2"&&(e=17),f=k,E=!1):H?(V=!0,j?(a=q?0:a-2,f=c+U[m]):(a=q?0:a-1,f=(q&&F&&I?U[m]:"")+c),E=!0,l=="h"?O=="c"&&(e=14):e=32,y=!1):M?(j?f=p+U[m]:f=(F&&!q?U[m]:"")+p,E=!0,y=q?!1:q):B?(a-=x.1k,f=h,y=!1,E=!1,e=32):1N?(F&&!q&&j&&(a-=1),f=v,y=!1,E=!1):e>=97&&e<=5f||e>=65&&e<=90?(E=!0,y=!0):(f=l.1y(),E=!1,y=!1)}1o g=e,X=z[x+f],T=x,x=f,X&&(f=X,a>-T.1k&&(a=-T.1k)),N=a,C=V,{5w:A,5v:-a,5u:f}},1g.4n=1c(){g=32,x=" ",y=!1,b=!1,w=!1,E=!1,S=!1,T=""},1g.31=1c(e,h,p){1f v,g=s,y,b,w,E=[],S=[],x={0:"",1:"",2:""},T={0:"",1:"",2:""},N=0,C,k,L,A=n,O=r,M=d,1N=i,D,P=34.3c,H=ek,B,j=u,F=!1,I=!0,q=-1,R=-1,U=-1,z=!1;h=h.3A(),p=p.3A();1p(1g.3i(h)){1p(h!=t)3J"4O.31(): a2 a4 be a3 a1 9Z 3z";1p(p!="3o"&&p!="4N")3J"4O.31(): 59 75 6X 6W"}4h{1p(h!="3o")3J"4O.31(): ew ex ey 1j a2 ez 59"+h+p;1p(!1g.3i(p)||p!=t)3J"4O.31(): 59 a4 be a3 a1 9Z 3z"}1g.4n();1p(p!="3o"&&p!="4N"){L=e.1k;1j(C=0;C<L;C++){B=e.3e(C),M=1g.8B(B);1j(k=1;k<=M.5v;k++)E.4G();D=M.5w?M.5u:e.3y(C);1j(k=0;k<D.1k;k++)E.1e(D.3y(k))}1o E.2k("")}F=p=="4N";1j(v 1z M)e=e.8(eE eF(M[v],"g"),v);L=e.1k;1j(C=0;C<L;C++){y=e.3y(C),b=e.3e(C),w=g[y],z=1J 1N[w]!="1K",eG="";1p(1J w=="1K")R==0&&(1J A[b]!="1K"||1J O[b]!="1K"||j||F&&U==2)?S.1e("a"):R==2&&!j&&S.1e("^^"),I==0&&F&&(I=!0,E.1e(5c(S.2k(""))),S=[]),q=-1,N=1,x[0]=y,S.1e(y);4h{N=0,I&&F&&(I=!1,E.1e(S.2k("")),S=[]);3Q(w.1k){1a 2:1a 3:x[0]=H(w,10),N=1;1h;1a 4:1a 5:x[0]=H(w.4v(0,2),10),x[1]=H(w.4v(2),10),N=2;1h;1a 6:x[0]=H(w.4v(0,3),10),x[1]=H(w.4v(3),10),N=2}a.4u(y)?(R==0&&S.1e("a"),q=0):c.4u(y)?q=0:f.4u(y)?(R==0?S.1e("a^"):R==1&&S.1e("^"),q=1):l.4u(y)?(R==0&&S.1e("a"),q=-1):(q=-1,j&&R==0&&z&&S.1e("a"));1j(k=0;k<N;k++){B=x[k];1p(B==m){q=2;eN}B==12?t=="2s"?S.1e("9e"):S.1e("eP"):B==13?t=="2s"?S.1e("9b"):S.1e("eR"):B==14?S.1e("ch"):B==15?S.1e("5B"):B==16?S.1e("8T"):B==17?o==3D?S.1e("12"):t=="3t"&&S.1e("H~"):B==18?S.1e("9b"):B==19?S.1e("9e"):(S.1e(P(B)),B==4K&&N==1&&T[0]==m&&S.1e("~"))}}T[0]=x[0],T[1]=x[1],U=R,R=q}1o R==0&&(j||F&&U==2)?S.1e("a"):R==2&&!j&&S.1e("^^"),!I&&F?E.1e(5c(S.2k(""))):E.1e(S.2k("")),1g.4n(),1J A["6z"]!="1K"?E.2k("").8(/j(4p|\\4m)/g,F?"gy":"3h"):E.2k("")};1f 5c=1c(e){1f r=n,s=i;1o s[2j]&&(e=e.8(/eX/g,"eY")),o==3D?(e=e.8(/M~([eZ])/g,"(n)$1").8(/M~/g,"(m)").8(/M([f0]|5P)/g,"n$1").8(/M([cj]|4p)/g,"\\4m$1").8(/M([f3]|N[^Y])/g,"\\5S$1").8(/M/g,"m$2"),e=e.8(/a~/g,"f5").8(/t~/g,"\\f6").8(/aU/g,"a\\3w")):t=="2s"?e=e.8(/([3S])M(~?)([3S])/g,"$1(n)$3").8(/(^|[^a])([21])M(~?)([6p])/g,"$1$2m$4").8(/(^|[^a])([a])M(~?)([3P][^h]|[6x]|3O|3h|[3N]$)/g,"$1$2n$4").8(/(^|[^a])([7d])M(~?)([3P][^h]|[6x]|3O|3h|[3N]$)/g,"$1$2(n)$4").8(/(^|[^a])([21])M(~?)([a-3g-Z])/g,"$1$2n$4").8(/(a[21]|[eo])M(~?)([7c]|t[^h]|t$|[7b]h)/g,"$1n$3").8(/(a[21]|[eo])M(~?)([b])/g,"$1m$3").8(/(a[21]|[eo])M(~?)([6U]|5B|s[^h]|s$)/g,"$1(n)$3").8(/(aa|[6V])M(~?)([^a-3g-Z]|$)/g,"$1(n)$3").8(/(a)M(~?)([^a-3g-Z]|$)/g,"$1m$3"):t=="3K"?e=e.8(/([3S])M(~?)([3S])/g,"$1(n)$3").8(/(^|[^a])([21])M(~?)([6p])/g,"$1$2m$4").8(/(^|[^a])([a])M(~?)([3P][^h]|[6x]|3O|3h|[3N]$)/g,"$1$2n$4").8(/(^|[^a])([7d])M(~?)([3P][^h]|[fr]|3O|3h|[3N]$)/g,"$1$2(n)$4").8(/(^|[^a])([21])M(~?)([a-3g-Z])/g,"$1$2n$4").8(/(a[21]|[eo])M(~?)([7c]|t[^h]|t$|[7b]h)/g,"$1n$3").8(/(a[21]|[eo])M(~?)([b])/g,"$1m$3").8(/(a[21]|[eo])M(~?)([6U]|5B|s[^h]|s$)/g,"$1(n)$3").8(/(aa|[6V])M(~?)([^a-3g-Z]|$)/g,"$1(n)$3").8(/(a)M(~?)([^a-3g-Z]|$)/g,"$1m$3"):t=="41"?e=e.8(/M(~?)$/g,"m").8(/M(~?)[6p]/g,"m").8(/M(~?)/g,"n"):e=e.8(/M(~?)([fs]|5P)/g,"\\7a$2").8(/M(~?)([cj]|4p)/g,"\\4m$2").8(/M(~?)([fu])/g,"\\5S$2").8(/M(~?)([fv])/g,"n$2").8(/M(~?)/g,"m$1"),o==0?(e=e.8(/@@/g,"").8(/[#\\$]/g,"").8(/@/g,".").8(/\'/g,s[39]),e=e.8(/k(h?)\\*/g,"\\6n$1").8(/g\\*/g,"\\86").8(/j\\*/g,"z").8(/D(h?)\\*/g,"\\87$1").8(/8b\\*/g,"f").8(/n\\*/g,"\\60").8(/r\\*/g,"\\3E").8(/y\\*/g,"\\5X").8(/L\\*/g,"\\5C"),t=="40"&&(e=e.8(/g~/g,"\\fE").8(/j~/g,"\\fF").8(/D~/g,"\\fG").8(/b~/g,"\\fH"))):o==7T?e=e.8(/&([^~]|$)/g,s[38]+"$1").8(/4i/g,"\\3E").8(/fJ/g,"\\5A").8(/fL/g,"\\3w").8(/y~/g,"\\5X").8(/@/g,"").8(/fM\\*/g,"\\6n$1").8(/g\\*/g,"\\86").8(/j\\*/g,"z").8(/8b\\*/g,"f").8(/l\\*/g,"\\5C").8(/s\\*/g,"fN"):o==8d?e=e.8(/4i/g,"\\3E").8(/F/g,"f").8(/e~/g,"\\fO").8(/aI/g,"a\\5A").8(/H(~?)(~?)/g,""):o==7R?e=e.8(/4i/g,"\\3E").8(/fP/g,"").8(/aU/g,"\\3w").8(/1@/g,"10").8(/1&/g,"4l").8(/1~/g,"9d").8(/1q/g,"1/4").8(/2q/g,"1/2").8(/3q/g,"3/4").8(/N\\*/g,"\\60").8(/n\\*/g,"\\fR").8(/r\\*/g,"\\9f").8(/l\\*/g,"\\5C").8(/L\\*/g,"\\9j").8(/k\\*/g,"\\6n"):o==8x?e=e.8(/Y/g,"\\5X").8(/D(h?)\\*/g,"\\87$1"):o==8t?e=e.8(/N~/g,"\\60").8(/L~/g,"\\9j").8(/aU/g,"\\3w").8(/R/g,"\\9f").8(/1@/g,"10").8(/1&/g,"4l").8(/1~/g,"9d").8(/fU/g,"n\\fV").8(/fW/g,"m\\fX").8(/fY/g,"fZ").8(/g0/g,"g1").8(/g2/g,"g3").8(/g4/g,"g5").8(/g6/g,"g7"):o==88&&(e=e.8(/4i/g,"\\3E").8(/g8/g,"g9").8(/ga/g,"dz").8(/@/g,"gb").8(/([gc])[~#]/g,"$1")),e=e.8(/8T(~?)/g,s[7r]).8(/\\+~/g,s[7p]).8(/\\|\\|/g,s[7t]).8(/\\|([^~])/g,s[7v]+"$1").8(/:([^~])/g,"\\gd$1").8(/\\&([^~])/g,"\'$1").8(/\\^(\\^?)([^~])/g,"$2").8(/([\\*])([^~])/g,"$2").8(/([A-ge-gf-9\\|:\\&\\^\\*])~/g,"$1").8(/5P/g,"\\7a").8(/4p/g,"\\4m").8(/T/g,"\\gg").8(/D/g,"\\gh").8(/N/g,"\\5S").8(/S/g,"\\gi").8(/L/g,"\\gj").8(/R/g,"\\gk").8(/aa|A/g,"\\gl").8(/ee|I/g,"\\5A").8(/E/g,"\\gm").8(/gn|U/g,"\\3w").8(/O/g,"\\go"),e};1g.gp=1c(e){1f t=d,n=v;1p(!e||e.1k==0||t.1k==0)1o e;1f r=1,i=e.1k,s=[],o,u=" ",a="",f;a=e.3y(0),s.1e(a);1j(r=1;r<i;r++){f=e.3y(r);1p(o=t[a+f]||n[a+f])s.4G(),f=o;4h 1p(o=n[u+a+f])s.4G(),s.4G(),f=o;s.1e(f),u=a,a=f}1o s.2k("")},1g.gq=1c(){1o[{3z:"3o",9p:"",9s:!0},{3z:"4N",9p:"",9s:!1}]},1g.gt=1c(){1o 1g.3L()+"-"+t+".gv"},1g.gw=1c(){1o 1g.3L()+"-"+t+".9w"},1g.gz=1c(e){1p(e<1||e>7)e=1;1f n=0;3Q(t){1a"6c":n++;1a"5Y":n++;1a"5W":n++;1a"6f":n++;1a"3t":n++;1a"6e":n++;1a"2s":n++;1a"3K":1a"6D":1a"6y":1a"6v":1a"6u":1a"6q":1a"6l":1a"6i":1a"40":1a"41":n++;1a"6M":1a"6K":1a"6J":n++}1o{gA:1g.3L()+"-"+"gB.9w",x:0,y:(n-1)*7*20+(e-1)*20}},1g.3L=1c(){1o"gD"},1g.gE=1c(){1o t},1g.a6=1c(){1o["6M","6J","6y","6v","2s","3K","3t","6l","6u","6f","6K","6D","6i","5W","6e","41","6q","40","5Y","6c"]},1g.3i=1c(e){1p(!e)1o!1;e=e.3A();1f t,n=1g.a6(),r=n.1k;1j(t=0;t<r;t++)1p(e==n[t])1o!0;1o!1},1g.3i(e)||(e="3K"),1g.6H(e)};',62,1034,'||||||||replace|||||||||||||||||||||||||||||||||||||||||||||||||||||||u094d|||||||||case|split|function|u093c|push|var|this|break|u093e|for|length|u0905|||return|if||u0abe|u0d4d|u0a85|u0915|u0958|u0947|u095f|toString|in|u091c|u0930|u0970|u0933|u0928|u0913|u0929|u0931|u094c|typeof|undefined|u095d|u0934|_|u0945|u0948|u0939|u0960|u0961|u090f|101|u094b|u0903|111|u09f1|u095e||aiu|8273|82105|delete|u091e|u0901|u09cd|u0937|u0966|u0950|u093d|u0932|u096f|u0935|u0951|u092a|13126|u0a3c|7977|join|u0963|||u0954|12126||u0cd5|gujarati|u0962|u0cc6|u02bc|u0d46|shree|u0d57|prashn|u0ac7|u09bc|u0ac5|u200d|u0946|u090c|118|u090b|u09c7|u0b47|u09be|u0944|u0906|u0972|u0911|u09f0|u0cca|u0bd7|u0c55|u0bca|u0a72|u0910|u0bc6|u0985|u0ac8|u0914|yaa|convert||padm|String|||u0a93|||u0d3e|u09d7|fromCharCode|u0a94|charCodeAt|u0a91|zA|Gy|supports|u0971|karm|u09e1|u09dc|u09cc|english|u09cb||u0b4b|u09e0|kannada|u0b57|119|u016b|u0bbe|charAt|language|toLowerCase|u0c4d|u0a73|128|u1e5f|u0c46|u0949|77126|u0ccd|throw|hindi|getKBName|101101|TN|kSh|kTp|switch|107|aeiou|prash|u09df|u0d4b|namaste|vidyaa|u0a86|u098b|sindhi|sanskrit||vidvaan|u0acc|u0acb|u0ac9|u0b71|||u09f2|u0b3c|u09fa|u0d4a|u0983|u0b3e|111111|else|Rr|u098c|116|100|u00f1|reset|9797|NY|u09ce|u0981|97117|u0d12|test|substring|u0912|82114|112|9785|u0d7a|u09b9|114|u0995|u0b56|49126|pop|u0cd6|42126|u0904|104|u0bcb|u09e2|readableenglish|PramuknIndic|u0cc7|u0acd|u09e3|u0b4d|u0b48|u09c8|u09bd|106104|u0b95|u09f9|u097f||||||||||ToLanguage|u0b05|u09f8|tt|u0b5f|u0b5c|122|112104|u0b83|u0b92|u0916|u09e6|u0917|u09ef|u0d47|u0921|120|u0922|u092b|u092f|38126|unicodeText|removeCharacters|letterConsumed|u094a|u0bc7|u0d4c|u012b|th|u1e3b|u0d33|suprabhaat|u09dd|u0ae0|u0d32|u0d30|u0d28|u099e|u0d0e|126|u0a8d|u0a8f|NG|u099c|u0d15|u1e47|16126|9773|u0ccb|oriya|u1e8f|tamil|u0c12|u1e49|u0c47|u0cc8|126126|||pra|auchity|||dusar|39126|telugu|u0c4a|punjabi|malayalam|u0c92|121|nepali|u0ce0|u0cde|konkani|u09c4|u1e33|u09b7|pbmv|santali|u09b6|u0a59|u0a5e|maithili|dogri|u09b2|hLv|bodo|71121|u0a70|u0a71|64126|marathi|u09aa|u09a8|u0993|setLanguage|u0990|bengali|manipuri|u098f|assamese|u0a38|u0a5c|u0a33|u0a36|u0a32|u0a42|u0a47|kcTphLGyrlvNnm|eiou|supported|not|u0a75|u0a51||u0a74|||u262c|is|||||u1e45|sS|gjDd|iu|u0a0f|u0a0a|u0a09|u0a08|83104|u0a03|u09af|u0a39|u0a90|78126|u5350|43126|u20b9|82115|u0965|124124|u0964|124|u200c|u090a|u0986|vid|u0c95|u0cb9|8285|u0c85|u0c94|82117|u0ce1|paig|u0c83|u0cbc|u0c8b|109|u0c8e|97105|aam|117|105|1024|u0c4b|256|u0c7f|u0c78|u0c4c|u0cb1|u0cbe|u0af1|u0c48|u0c56|||||u0121|u1e0f|768||3535|ph|u0ccc|896|u0ac4|u0cf1|u0cf2|u0c59|u0c58|raatri|17126|51126|u0c0e|u0c03|u0c61|u0c60|u0c14|50126|u0c05|640|u0c39|3636|u0c15|512|u0cbf|u0cc0|u0cc2|process|u0bb1|u0d7f|u0d05|u0d14|u0d60|u0d61|u0d02|u0d03|98104|115104|u0a8b|u0d10|u0abc|u0a83|100104|u0a81|u0ae1|Rs|111117|u0ab9|PramukhIndic|116104|68104|u0d31||u0d34|u0a95|pad||84104|103104|||bidyaa|103|Lu|u09b0|1000|LU|u1e59|u0d70|107104|110|u1e39|namaskaaraM|6464|u095c|14104|u0bf0|preferredFont|u0bcd|u0d13|reverseConversionSupported|u095b|4964|4938|png|u095a|u0959|u0d23|u0baa|u0ba8|u0ba3|35126|u0b8e|u0b8a|102|u0b94|u0b15|u0b39|u0900|u0977|u0979|karma|u0b14|u0b60|u0b61|u0b01|u0b03|u090d|u0b85|u0bb9|u0b0f|u0b10|u0b13|selected|u0b70|currently|FromLanguage|the|must|108|getLanguages|u0b1e|u0b44|u0b62||u0b63|u0b1c|u0b37|u0b33|u0b35|u0b32|u0b4c|u0b3d|u0b30|u0b66|u0b6f|shubhechchhaa||mu|paD|ichhi|u0b21|u0b22|u0b06|u0b2a|u0b28|u0b0c|u0b0b|u0d7e|u0b80|u0d7d|u0bbc|u0d7c|u0d7b|u0b90|u0d0a|u0b99|u0b9a||u0b9c|u0b9e|u0b9f||u0d09|u0ba4|u0d08|u0d07|u0bae|100116|u0bc2||51113|u0bc8|50113|49113|122104|u0bcc|u0b82|u0d0f|u0bd0|ma|u0bfa|u0be6|u0bef|vaNakkam|NNanrri||sree|Hkaan|uNavu||jan|janma|74104|tarunnu|u0b8f|u0b93|u0d6f|u0d66|u0ba9|76126|u0bb4|u0bb7|u0d79|68121|77111|89114|6898|67114|6598|78111|u0d75|u0d3d|u0d48|u0d63|u0d62|u0d44|u0d1e|u0d1c|u0d37|u0d39|u0d35|u0d2a|u0d0c|u0d0b|u0001|u0d3a|u0b89|72126|101126|u0c93|u0c8f|rage|kar|u0c00|karrage|u0c3c|u0c0b|u0c0c|kartavya|u0c10|kraaMti|u0c28|u0c2a|u0c32|u0c35|u0c33|eShTu|u0c37|u0c1c|u0c1e|madhyaahna|u0cef|u0ce6|u0c3e||u0c44||u0c62|u0c63|u0cbd|u0c82|u0ce3|u0ce2|u0cc4|u0c9e|u0c01|u0c3d|u0c9c|u0cb7|u0c66|u0c6f|varShaM|pakShulni|ekspresa|eks|presa|u0c31|84115|68122|48126|4935|5035|5135|u0c13|u0cb3|u0cb5|u0cb2|u0cb0|u0caa|u0ca8|u0c90|7871|99104|106|7889|u0c8c|u0c81|115|u0a41|u0a07|9494|u0a3f|u0a40|u0a2b|u0a5b|u0a1c|u0a5a|u0a17|u0a16|121126|124126|94126|58126|109126|8582|7382|aushad|shrI|maa|kram|tuhaaDaa|raatarI|u0a6f|u0a66|u0a4d|u0a01|u0a4c|u0a4b|u0a48|u0a3e|u0a35|u0a30|u0a2a|u0a28||u0a13|384|u0a10|u0a05|u0a00|u0a14|u0a04|u0a15|u0ac3|daMDavat|ghoSh|ud|ann|u0aef|u0ae6|u0abd|u0ad0|u0ae3|u0ae2|u0a9e|u0a9c|u0ab7|u0ab5|getChars|u0ab3|u0ab2|getExamples|u0ab0|u0aaa|u0aa8|127|u0a8c|u090e|u0941|u0909|36126|u0953|u0952|raatree|98126||u097e|68126|u097c|default|106126|parseInt|u097b|103126|patra||tavhaaM|olee|aayo|lUmaD||paMrhijo|saMvidhaanam|provide|valid|values|and|vakrataa|ravi|hRidayam|padma|new|RegExp|charpush|kRiShNa|sarvam|saMvidhaan|smRiti|rupaiyaaM|teebra|continue|yaaeko|LI|dohor|Li|raaShTreeya|gardaa|garchha|koMkaNee|khar|OM|aum|kgcjTDNtdn|kgtdn|mishra|hisra|TD|varsaa|ana|u1e6f|nhaMy|u0942|jee|pUM|vargeey|pRiShTh|gelh|chitra|dosajh|aarya|nna|looMddhee|trai|rlaanaa|sujjanaa|baathraa|dinthifu|nemakhaanthI|gaajag|ja|chLv|kg|oMthi|TDN|tdn|u09c3|u09a2|u09a1|116126|97126|52126|84126|u0994|u1e21|u017c|u1e0b|uae07|raaShTr|IR|biShNupriy|UR|kh|sh|u0113|zh|39128|u1e4b|pRiShThaa|dUrghaTanaa|Dy|u0101l|Mo|u0101tham|Yr|varudam|Db|patru|Cr|varavu|Ab|merpadi|No|enn|Ts|ts|Dz|tumu|0123|u1e25|Za|z0|u1e6d|u1e0d|u1e63|u1e37|u1e5b|u0101|u0115|oo|u014f|rectify|getConversionLanguage|mUlya|tris|getHelp|achhoM|htm|getHelpImage|gaa||getIcon|iconFile|icon|999|pramukhindic|getLanguage|u0b5d'.split('|'),0,{}));

	pramukhIME.addLanguage(PramukhIndic);
$.fn.juirte = function(options){

	/*
	* based on the example @ http://stackoverflow.com/questions/5281438/how-to-create-a-text-editor-in-jquery
	* 
	* to-do:
	* - add function 'hook' stype things: http://www.learningjquery.com/2009/03/making-a-jquery-plugin-truly-customizable
	* - add functions we can access like: $.fn.juirte.synccontents=function(){fnSyncContents()};
	* - add a function to SetContent so we can update it when the dialog opens
	*/

	// define settings
	var settings = $.extend({
		resizable: false,
		stylesheet: '',
		language: [['html', 'Toggle HTML'],['insertimage', 'Insert Image'],['inserturl', 'Insert URL'],['paragraph', 'Paragraph'],['address', 'Address'],['heading', 'Heading'],['bgcolor', 'Background Color'],['fontcolor', 'Font Color'],['fontsize', 'Font Size'],['font', 'Font'],['paragraph', 'Paragraph'],['link', 'Link'],['removelink', 'Remove Link'],['italic', 'Italic'],['bold', 'Bold'],['underline', 'Underline'],['strike', 'Strike'],['hr', 'Horizontal Rule'],['ol', 'Ordered List'],['ul', 'Unordered List'],['center', 'Center'],['left', 'Left'],['full', 'Full'],['right', 'Right'],['indent', 'Indent'],['outdent', 'Outdent'],['superscript', 'Superscript'],['subscript', 'Subscript'],['rm', 'Remove Formating'], ['language', 'Language'], ['?', '?']],
		width : "400px",
		height : "200px",
		colors : ['#FFFFFF', '#C0C0C0', '#808080', '#000000', '#FF0000', '#800000', '#FFFF00', '#808000', '#00FF00', '#008000', '#00FFFF', '#008080', '#0000FF', '#000080', '#FF00FF', '#800080'],
		fonts : ["Arial","Comic Sans MS","Courier New","Monotype Corsiva","Tahoma","Times"],
		buttons: [
			'italic', 'bold', 'underline', 'strikeThrough',
			'spacer','heading', 'fonts', 'fontSize',
			'spacer','removeFormat',
			'spacer', 'insertImage', 'createlink','unlink', 
			'spacer', 'language', '?',
			'row', 'html',
			'spacer','backColor', 'forecolor',
			'spacer', 'justifyCenter', 'justifyFull', 'justifyLeft', 'justifyRight',
			'spacer', 'insertHorizontalRule',
			'spacer', 'insertOrderedList', 'insertUnorderedList',
			'spacer','indent', 'outdent', 'superscript', 'subscript'
		],
		languages : ["english", "assamese", "bengali" ,"bodo" ,"dogri", "gujarati", "hindi", "kannada", "konkani" ,"maithili", "malayalam", "manipuri", "marathi" ,"nepali"  ,"oriya"   ,"punjabi" ,"sanskrit","santali" ,"sindhi"  ,"tamil" ,"telugu" ]
	}, options);

	// define translation 
	var lang=new Array();
	$.each(settings.language,function(i,v){lang[v[0]]=v[1]});

	// loop over all editors
	return this.each(function(){
		// wrapper to exec command
		$.fn.juirte.exec = function(e){fnExecCommand(e)}

		var _id=$(this).attr('id');
		var $this = $(this).hide();
		//var $this= $(this);
		var _wrapper = '#'+_id+'-wrapper';

		// wrap everything in a widget container
		var _container = $("<div/>",{
			"class": 'ui-wysiwyg ui-widget ui-widget-content ui-corner-all ui-wysiwyg-container',
			css : { width : settings.width , height : settings.height },
			id: _id+'-wrapper'
		});
		
	//	alert(_id);

		if(settings.resizable) _container.resizable();

       $this.after(_container); 

		// write the iframe to be editable
		var editor = $("<iframe/>",{
			css : { height: '100%', width: '100%' },
			frameborder : '0', marginwidth: '0', marginheight: '0',
			"class": _id+'-wysiwyg-content ui-wysiwyg-content',
			id: _id+'-editor',
			designMode : 'on'
		}).appendTo(_container).get(0);
		
		



		$.fn.juirte.write = function(e){
			$('.'+_id+'-wysiwyg-content').contents().find('body').html('');
			editor.contentWindow.document.write(e);
			$(_wrapper).find('.ui-wysiwyg-html').val(e);
			if(settings.stylesheet !=''){
				$('.'+_id+'-wysiwyg-content').contents().find('head').append($('<link/>', { rel: 'stylesheet', href: settings.stylesheet, type: 'text/css' }));
				$('.'+_id+'-wysiwyg-content').contents().find('head').append('<style type="text/css">.ui-widget{ font-size: 14px; background: #fff}</style>');
				$('.'+_id+'-wysiwyg-content').contents().find('body').addClass('ui-widget');
			}

			// set button status, cross browser required us to bind on load and outside of load
			$('.'+_id+'-wysiwyg-content').load(function() {
				$('.'+_id+'-wysiwyg-content').contents().find("body").bind('click', function(event) {
					fnSetButtons(event)
				});
			});
			$('.'+_id+'-wysiwyg-content').contents().find('body').bind('click',function(event){
				fnSetButtons(event)
			});
		}

		var _htmleditor=$('<textarea/>', {
			"class": 'ui-wysiwyg-html ui-widget-content ui-corner-top',
			css: {'display':'none','margin':'0px','margin-left':'2px', 'margin-bottom':'1px', height: '98%', width: '99%', 'border':'0px'	},
		    id : _id + '-textarea'

		}).appendTo(_container);

		
		pramukhIME.enable(_htmleditor.id);
		pramukhIME.setLanguage('', 'english');
		// define the editor and make it writable, add default values of the textarea - firefox needs the doc open, it messes up other browsers when placed in dialogs
		if(navigator.userAgent.match(/mozilla/i)) editor.contentWindow.document.open();
		$.fn.juirte.write($(this).val());
		if(navigator.userAgent.match(/mozilla/i)) editor.contentWindow.document.close();
		editor.contentWindow.document.designMode="on";
		pramukhIME.enable(editor.id);
		// disable css mode for editing
		fnDisableCSS();

		// update original textarea when contents change
		$('.'+_id+'-wysiwyg-content').contents().bind("keyup keydown keypress focus blur", function() {fnSyncContents()});
		$(_wrapper).find('.ui-wysiwyg-html').bind("keyup keydown keypress focus blur", function() {fnSyncContentsFromHTML()});
		$('.'+_id+'-wysiwyg-content').contents().hover(function(){fnSyncContents()});

		// append menu container to overall container
		var wysiwyg_menu = $("<div/>",{
			"class" : "ui-widget ui-widget-content ui-widget-header ui-corner-bottom  ui-wysiwyg-menu",
			css : { width : '100%' }
		}).appendTo(_container);

		// append button container to menu container
		var _button_panel = $("<div/>",{
			"class" : "ui-wysiwyg-menu-wrap",
			css : { width : '100%' }
		}).appendTo(wysiwyg_menu);

		// create button wrappers for rows/spacers
		var _i=0;
		var _buttonwrap=$('<div/>', {"class": 'ui-wysiwyg-set'+_i+' ui-wysiwyg-left'});

		// loop buttons and insert to containers
		$.each(settings.buttons,function(i,v){
			var _options=fnGetButton(v);

			if(v == 'spacer' || v == 'row'){
				_i++;
				var _class='ui-wysiwyg-set'+_i+' ui-wysiwyg-left';
				if(v == 'row') _class=_class+' ui-wysiwyg-row';
				_buttonwrap.buttonset().appendTo(_button_panel);
				_buttonwrap=$('<div/>', {"class": _class});
			} else if(v == 'backColor'){
				var _fontlink=$("<a/>",{
					href : "#",
					title: _options.title,
					style: _options.style,
					text : _options.text,
					"class" : 'ui-wysiwyg-dd-fntbgcbtn  ui-wysiwyg-btn ui-wysiwyg-btn-'+v,
					click : function(){
						if ( $(_wrapper).find('.ui-wysiwyg-fontbgcdropdown').is(":visible") ) {
							$(_wrapper).find('.ui-wysiwyg-fontbgcdropdown').hide();
						} else { 
							var _pos=$(this).offset();
							_pos.top=_pos.top-129;
							$(_wrapper).find('.ui-wysiwyg-fontbgcdropdown').show().offset(_pos);
						}
						return false;
					}
				}).button(_options.icon).appendTo(_buttonwrap);

				var _fontmenu=$('<ul/>').html('');
				$.each(settings.colors,function(i,v){
					$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-fntbgcbtn span').css('background-color', v);fnRunCommand('backColor', v);return false;}}).html('<a href="#" style="background:'+v+'" class="ui-wysiwyg-swatch" title="'+v+'"></a>').appendTo(_fontmenu);
				});

				var _colorinput=$('<input>',{
					type: 'text',
					"class": 'ui-wysiwyg-colorinput',
					keypress: function(e) {if( e.keyCode == 13 ) fnRunCommand('backColor', $(this).val())}
				});

				var _fontbgcontainer=$('<div/>',{
					"class" : 'ui-wysiwyg-dropdown ui-wysiwyg-fontbgcdropdown ui-widget ui-widget-content ui-corner-all',
					style: ' margin: 0px'
				}).append(_colorinput).append(_fontmenu).appendTo(_container);


			} else if(v == 'forecolor'){
				var _fontlink=$("<a/>",{
					href : "#",
					title: _options.title,
					style: _options.style,
					text : _options.text,
					"class" : 'ui-wysiwyg-dd-fntclbtn  ui-wysiwyg-btn ui-wysiwyg-btn-'+v,
					click : function(){
						if ( $(_wrapper).find('.ui-wysiwyg-fontcldropdown').is(":visible") ) {
							$(_wrapper).find('.ui-wysiwyg-fontcldropdown').hide();
						} else { 
							var _pos=$(this).offset();
							_pos.top=_pos.top-129;
							$(_wrapper).find('.ui-wysiwyg-fontcldropdown').show().offset(_pos);
						}
						return false;
					}
				}).button(_options.icon).appendTo(_buttonwrap);

				var _fontmenu=$('<ul/>').html('');
				$.each(settings.colors,function(i,v){
					$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-fntclbtn span').css('background-color', v);fnRunCommand('forecolor', v);return false}}).html('<a href="#" style="background:'+v+'" class="ui-wysiwyg-swatch" title="'+v+'"></a>').appendTo(_fontmenu);
				});

				var _colorinput=$('<input>',{
					type: 'text',
					"class": 'ui-wysiwyg-colorinput',
					keypress: function(e) {if( e.keyCode == 13 ) fnRunCommand('forecolor', $(this).val())}
				});

				$('<div/>',{
					"class" : 'ui-wysiwyg-dropdown ui-wysiwyg-fontcldropdown ui-widget ui-widget-content ui-corner-all',
					style: ' margin: 0px'
				}).append(_colorinput).append(_fontmenu).appendTo(_container);


			} else if(v == 'fontSize'){
				var _fontlink=$("<a/>",{
					href : "#",
					title: _options.title,
					style: _options.style,
					text : _options.text,
					"class" : 'ui-wysiwyg-dd-fntszbtn  ui-wysiwyg-btn ui-wysiwyg-btn-'+v,
					click : function(){
						if ( $(_wrapper).find('.ui-wysiwyg-fontszdropdown').is(":visible") ) {
							$(_wrapper).find('.ui-wysiwyg-fontszdropdown').hide();
						} else { 
							var _pos=$(this).offset();
							_pos.top=_pos.top-66;
							_pos.left=_pos.left-24;
							$(_wrapper).find('.ui-wysiwyg-fontszdropdown').show().offset(_pos);
						}

						return false;

					}
				}).button(_options.icon).appendTo(_buttonwrap);

				var _fontsize = ['1','2','3','4','5','6','7'];
				var _fontmenu=$('<table/>').html('');
				$.each(_fontsize,function(i,v){
					$('<td/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-fntszbtn span').text(v);fnRunCommand('fontSize', v);return false}}).html('<a href="#"><font size="'+v+'">'+v+'</font></a>').appendTo(_fontmenu);
				});


				$('<div/>',{
					"class" : 'ui-wysiwyg-dropdown ui-wysiwyg-fontszdropdown ui-widget ui-widget-content ui-corner-all',
					style: ' margin: 0px'
				}).append(_fontmenu).appendTo(_container);

			} else if(v == 'fonts'){
				var _fontlink=$("<a/>",{
					href : "#",
					title: _options.title,
					style: _options.style,
					text : _options.text,
					"class" : 'ui-wysiwyg-dd-fntbtn  ui-wysiwyg-btn ui-wysiwyg-btn-'+v,
					click : function(){
						if ( $(_wrapper).find('.ui-wysiwyg-fontdropdown').is(":visible") ) {
							$(_wrapper).find('.ui-wysiwyg-fontdropdown').hide();
						} else { 
							var _pos=$(this).offset();
							_pos.top=_pos.top-121;
							$(_wrapper).find('.ui-wysiwyg-fontdropdown').show().offset(_pos);
						}
						return false;
					}
				}).button(_options.icon).appendTo(_buttonwrap);

				var _fontmenu=$('<ul/>').html('');
				$.each(settings.fonts,function(i,v){
					$('<li/>', {click: function(){
						if(v.length > 5){
							var _fontface=v.substr(0, 5)+'..';
						} else var _fontface=v;

						$(_wrapper).find('.ui-wysiwyg-dd-fntbtn span').text(_fontface);
						fnRunCommand('FontName', v);
						return false
					}}).html('<a href="#"><font face="'+v+'">'+v+'</font></a>').appendTo(_fontmenu);
				});

				$('<div/>',{
					"class" : 'ui-wysiwyg-dropdown ui-wysiwyg-fontdropdown ui-widget ui-widget-content ui-corner-all',
					style: ' margin: 0px'
				}).append(_fontmenu).appendTo(_container);
			} 
			else if(v == 'language'){
				var _languagelink=$("<a/>",{
					href : "#",
					title: _options.title,
					style: _options.style,
					text : _options.text,
					"class": "ui-wysiwyg-dd-lngbtn ui-wysiwyg-btn ui-wysiwyg-btn-" + v,
					click : function(){
						if ( $(_wrapper).find('.ui-wysiwyg-languagedropdown').is(":visible") ) {
							$(_wrapper).find('.ui-wysiwyg-languagedropdown').hide();
						} else { 
							var _pos=$(this).offset();
							_pos.top=_pos.top-121;
							$(_wrapper).find('.ui-wysiwyg-languagedropdown').show().offset(_pos);
						}
						return false;
					}
				}).button(_options.icon).appendTo(_buttonwrap);

				var _languagemenu=$('<ul/>').html('');
				$.each(settings.languages,function(j,v){
					$('<li/>', {click: function(){
						fnSetlanguage(v, _languagelink);
						$(_wrapper).find('.ui-wysiwyg-dd-lngbtn span').text(v);
						return false;
					}}).html('<a href="#">'+v+'</a>').appendTo(_languagemenu);
				});

				$('<div/>',{
					"class" : 'ui-wysiwyg-dropdown ui-wysiwyg-languagedropdown ui-widget ui-widget-content ui-corner-all',
					style: ' margin: 0px'
				}).append(_languagemenu).appendTo(_container);
			}
			else if(v == 'heading'){
				var _headmenu=$("<a/>",{
					href : "#",
					title: _options.title,
					style: _options.style,
					text : _options.text,
					"class" : 'ui-wysiwyg-dd-btn ui-wysiwyg-btn ui-wysiwyg-btn-'+v,
					click : function(){
						if ( $(_wrapper).find('.ui-wysiwyg-hddropdown').is(":visible") ) {
							$(_wrapper).find('.ui-wysiwyg-hddropdown').hide();
						} else { 
							var _pos=$(this).offset();
							_pos.top=_pos.top-154;
							$(_wrapper).find('.ui-wysiwyg-hddropdown').show().offset(_pos);
						}
						return false;
					}
				}).button(_options.icon).appendTo(_buttonwrap);

				var _headermenu=$('<ul/>').html('');
				//TO-DO: make from array
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.paragraph);fnRunCommand('formatBlock', '<p>'); return false}}).html('<a href="#">'+lang.paragraph+'</a>').appendTo(_headermenu);
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.address);fnRunCommand('formatBlock', '<address>'); return false}}).html('<a href="#"><address>'+lang.address+'</address></a>').appendTo(_headermenu);
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 1');fnRunCommand('formatBlock', '<h1>'); return false}}).html('<a href="#"><h1>'+lang.heading+' 1</h1></a>').appendTo(_headermenu);
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 2');fnRunCommand('formatBlock', '<h2>'); return false}}).html('<a href="#"><h2>'+lang.heading+' 2</h2></a>').appendTo(_headermenu);
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 3');fnRunCommand('formatBlock', '<h3>'); return false}}).html('<a href="#"><h3>'+lang.heading+' 3</h3></a>').appendTo(_headermenu);
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 4');fnRunCommand('formatBlock', '<h4>'); return false}}).html('<a href="#"><h4>'+lang.heading+' 4</h4></a>').appendTo(_headermenu);
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 5');fnRunCommand('formatBlock', '<h5>'); return false}}).html('<a href="#"><h5>'+lang.heading+' 5</h5></a>').appendTo(_headermenu);
				$('<li/>', {click: function(){$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 6');fnRunCommand('formatBlock', '<h6>'); return false}}).html('<a href="#"><h6>'+lang.heading+' 6</h6></a>').appendTo(_headermenu);



				$('<div/>',{
					"class" : 'ui-wysiwyg-dropdown ui-wysiwyg-hddropdown ui-widget ui-widget-content ui-corner-all',
					style: 'font-size: 60%; margin: 0px'
				}).append(_headermenu).prependTo(_container);
			} else {
				$("<a/>",{
					href : "#",
					title: _options.title,
					style: _options.style,
					html : _options.text,
					"class" : 'ui-wysiwyg-btn ui-wysiwyg-btn-'+v+' ui-wysiwyg-btn-'+_options.tag+' '+_options.className,
					data : {
						commandName : v,
						"class" : _options.className
					},
					click : fnExecCommand 
				}).button(_options.icon).appendTo(_buttonwrap);
			}
		}); 
		_buttonwrap.buttonset().appendTo(_button_panel);

		// add a clear fix to clean up floating items
		_button_panel.append($('<div/>', { "class": 'ui-helper-clearfix'}));

		// hide any drop down when clicked
		$(document).bind('click', function (e){fnHideDropDowns(e)});
		$('.ui-wysiwyg-btn').bind('click', function (e){fnHideDropDowns(e)});

		function fnHideDropDowns(e){
			if(!$(e.target).parents().hasClass('ui-wysiwyg-dropdown')){
				if (!$(e.target).parents().hasClass('ui-wysiwyg-dd-btn'))$('.ui-wysiwyg-hddropdown').hide();
				if (!$(e.target).parents().hasClass('ui-wysiwyg-dd-fntbtn'))$('.ui-wysiwyg-fontdropdown').hide();
				if (!$(e.target).parents().hasClass('ui-wysiwyg-dd-fntszbtn'))$('.ui-wysiwyg-fontszdropdown').hide();
				if (!$(e.target).parents().hasClass('ui-wysiwyg-dd-fntclbtn'))$('.ui-wysiwyg-fontcldropdown').hide();
				if (!$(e.target).parents().hasClass('ui-wysiwyg-dd-fntbgcbtn'))$('.ui-wysiwyg-fontbgcdropdown').hide();
			}
		}

		// disable css modes
		function fnDisableCSS(){
			var contentWindow = editor.contentWindow;

			try {
                contentWindow.document.execCommand("styleWithCSS", 0, false);
            } catch (e) {
                try {
                 contentWindow.document.execCommand("useCSS", 0, true);
                } catch (e) {

                    try {
                        contentWindow.document.execCommand('styleWithCSS', false, false);
                    }
                    catch (e) {

                    }
                }
            }
		}

		// set button states if the editor has the tag
		function fnSetButtons(event){
			// reset dropdowns
			//TO-DO: make from array or find optimzation
			$(_wrapper).find('.ui-wysiwyg-dd-fntbtn span').text(lang.font);
			$(_wrapper).find('.ui-wysiwyg-dd-fntszbtn span').text(lang.fontsize);
			$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.paragraph);
			$(_wrapper).find('.ui-wysiwyg-dd-fntclbtn').button({icons: { secondary: "ui-icon-triangle-1-s"}});
			$(_wrapper).find('.ui-wysiwyg-dd-fntbgcbtn').button({icons: { secondary: "ui-icon-triangle-1-s"}});
			$(_wrapper).find('.ui-wysiwyg-fontcldropdown .ui-wysiwyg-colorinput').val('');
			$(_wrapper).find('.ui-wysiwyg-fontbgcdropdown .ui-wysiwyg-colorinput').val('');


			// loop over buttons and set their status
			$.each(settings.buttons,function(i,v){ $(_wrapper).find('.ui-wysiwyg-btn-'+v).removeClass('ui-state-hover ui-state-focus'); });
			var elm=event.target ? event.target : event.srcElement;
			do {
				var _tag=elm.tagName.toUpperCase();
				if(_tag == 'BODY' || _tag == 'HTML') break;
				//console.log(_tag);
				// some conversions
				if(_tag == 'STRONG') _tag = 'B';
				// set the heading drop down
				switch(_tag){
					case 'ADDRESS':
						$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.address);
					break;
					case 'H1':
						$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 1');
					break;
					case 'H2':
						$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 2');
					break;
					case 'H3':
						$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 3');
					break;
					case 'H4':
						$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 4');
					break;
					case 'H5':
						$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 5');
					break;
					case 'H6':
						$(_wrapper).find('.ui-wysiwyg-dd-btn span').text(lang.heading+' 6');
					break;
				}

				// set the font drop downs
				if(_tag == 'FONT'){
					if(elm.face){
						if(elm.face.length > 5){
							var _fontface=elm.face.substr(0, 5)+'..';
						} else var _fontface=elm.face;
						$(_wrapper).find('.ui-wysiwyg-dd-fntbtn span').text(_fontface);
					}
					if(elm.size) $(_wrapper).find('.ui-wysiwyg-dd-fntszbtn span').text(elm.size);
					if(elm.color){
						$(_wrapper).find('.ui-wysiwyg-dd-fntclbtn span').css('background-color', elm.color);
						$(_wrapper).find('.ui-wysiwyg-fontcldropdown .ui-wysiwyg-colorinput').val(elm.color);
					}

				}
				// set background color
				try{
					if($(elm).css('background-color')){
						if($(elm).css('backgroundColor') != 'transparent'){
							$(_wrapper).find('.ui-wysiwyg-dd-fntbgcbtn span').css('background-color', $(elm).css('backgroundColor'));
							$(_wrapper).find('.ui-wysiwyg-fontbgcdropdown .ui-wysiwyg-colorinput').val($(elm).css('backgroundColor'));
						}
					}
				} catch (e){
					// opera bug
				}

				// set the justify items
				if($(elm).css('text-align')){
					var _align=$(elm).css('text-align');
					switch(_align){
						case 'right':
							$(_wrapper).find('.ui-wysiwyg-btn-justifyRight').addClass('ui-state-hover ui-state-focus');
						break;
						case 'left':
							$(_wrapper).find('.ui-wysiwyg-btn-justifyLeft').addClass('ui-state-hover ui-state-focus');
						break;
						case 'center':
							$(_wrapper).find('.ui-wysiwyg-btn-justifyCenter').addClass('ui-state-hover ui-state-focus');
						break;
						case 'justify':
							$(_wrapper).find('.ui-wysiwyg-btn-justifyFull').addClass('ui-state-hover ui-state-focus');
						break;
					}
				}
				if( $(_wrapper).find('.ui-wysiwyg-btn-'+_tag))$(_wrapper).find('.ui-wysiwyg-btn-'+_tag).addClass('ui-state-hover ui-state-focus');
			} while ((elm = elm.parentNode));
		}

		// button settings           
		function fnGetButton(type){
			var _result = new Object;

			_result.style=null;
			_result.className=null;
			_result.title=null;
			_result.icon=null;

			switch(type){
				case 'html':
					_result.title=lang.html;
					_result.text='&lsaquo;/&rsaquo;';
					_result.className='';
					_result.icon=null;
					_result.tag='';
				break;

				case 'backColor':
					_result.title=lang.bgcolor;
					_result.text='BG';
					_result.className='';
					_result.icon={icons: {secondary: "ui-icon-triangle-1-s"}};
					_result.tag='FONT';
				break;

				case 'forecolor':
					_result.title=lang.fontcolor;
					_result.text='A';
					_result.style='text-decoration: underline';
					_result.className='';
					_result.icon={icons: { secondary: "ui-icon-triangle-1-s"}};
					_result.tag='FONT';
				break;

				case 'fontSize':
					_result.title=lang.fontsize;
					_result.text=lang.fontsize;
					_result.className='';
					_result.icon={icons: { secondary: "ui-icon-triangle-1-s"}};
					_result.tag='FONT';
				break;

				case 'fonts':
					_result.title=lang.font;
					_result.text=lang.font;
					_result.className='';
					_result.icon={icons: { secondary: "ui-icon-triangle-1-s"}};
					_result.tag='FONT';
				break;
				
				case 'language':
					_result.title=lang.language;
					_result.text=lang.language;
					_result.className='';
					_result.icon={icons: { secondary: "ui-icon-triangle-1-s"}};
					_result.tag='';
				break;				

				case 'heading':
					_result.title=lang.heading;
					_result.text=lang.paragraph;
					_result.className='';
					_result.icon={icons: { secondary: "ui-icon-triangle-1-s"}};
					_result.tag='H';
				break;

				case 'createlink':
					_result.text=lang.link;
					_result.className='';
					_result.icon={icons: { primary: "ui-icon-link"}, text: false};
					_result.tag='';
				break;

				case 'unlink':
					_result.text=lang.removelink;
					_result.className='';
					_result.icon={icons: { primary: "ui-icon-cancel"}, text: false};
					_result.tag='A';
				break;

				case 'italic':
					_result.title=lang.italic;
					_result.text='I';
					_result.style='font-style: italic';
					_result.className='';
					_result.icon=null;
					_result.tag='I';
				break;

				case 'bold':
					_result.title=lang.bold;
					_result.text='B';
					_result.style='font-weight: bold';
					_result.className='';
					_result.icon=null;
					_result.tag='B';
				break;

				case 'underline':
					_result.title=lang.underline;
					_result.text='U';
					_result.style='text-decoration: underline';
					_result.className='';
					_result.icon=null;
					_result.tag='U';
				break;

				case 'strikeThrough':
					_result.title=lang.strike;
					_result.text='ABC';
					_result.style='text-decoration: line-through';
					_result.className='';
					_result.icon=null;
					_result.tag='STRIKE';
				break;

				case 'insertHorizontalRule':
					_result.text=lang.hr;
					_result.className='';
					_result.icon={icons: { primary: "ui-icon-minusthick"}, text: false};
					_result.tag='HR';
				break;

				case 'insertOrderedList':
					_result.title=lang.ol;
					_result.text='<div class="ui-wysiwyg-list-wrap">1 ---<br>2 ---<br>3 ---</div>';
					_result.className='ui-wysiwyg-list';
					_result.icon=null;
					_result.tag='OL';
				break;

				case 'insertUnorderedList':
					_result.title=lang.ul;
					_result.text='<div class="ui-wysiwyg-list-wrap">&bull; ---<br>&bull; ---<br>&bull; ---</div>';
					_result.className='ui-wysiwyg-list';
					_result.icon=null;
					_result.tag='UL';
				break;

				case 'justifyCenter':
					_result.text='<div class="ui-wysiwyg-justify-wrap ui-wysiwyg-justify-center">__<br>_<br>__<br>_<br>__<br>_<br>__<br><br></div>';
					_result.title=lang.center;
					_result.className='ui-wysiwyg-justify';
					_result.icon=null;
					_result.style='';
					_result.tag='CENTER';
				break;

				case 'justifyLeft':
					_result.text='<div class="ui-wysiwyg-justify-wrap">__<br>_<br>__<br>_<br>__<br>_<br>__<br><br></div>';
					_result.title=lang.left;
					_result.className='ui-wysiwyg-justify';
					_result.icon=null;
					_result.tag='';
				break;

				case 'justifyFull':
					_result.text='<div class="ui-wysiwyg-justify-wrap">__<br>__<br>__<br>__<br>__<br>__<br>__<br><br></div>';
					_result.title=lang.full;
					_result.className='ui-wysiwyg-justify';
					_result.icon=null;
					_result.tag='';
				break;	

				case 'justifyRight':
					_result.text='<div class="ui-wysiwyg-justify-wrap ui-wysiwyg-justify-right">__<br>_<br>__<br>_<br>__<br>_<br>__<br><br></div>';
					_result.title=lang.right;
					_result.className='ui-wysiwyg-justify';
					_result.icon=null;
					_result.tag='';
				break;

				case 'indent':
					_result.text=lang.indent;
					_result.className='ui-wysiwyg-dent';
					_result.icon={icons: { primary: "ui-icon-arrowthickstop-1-e"}, text: false};
					_result.tag='BLOCKQUOTE';
				break;

				case 'outdent':
					_result.text=lang.outdent;
					_result.className='ui-wysiwyg-dent';
					_result.icon={icons: { primary: "ui-icon-arrowthickstop-1-w"}, text: false};
					_result.tag='';
				break;

				case 'superscript':
					_result.text='x<sup>2</sup>';
					_result.title=lang.superscript;
					_result.className='ui-wysiwyg-script';
					_result.icon=null;
					_result.tag='SUP';
				break;

				case 'subscript':
					_result.text='x<sub>2</sub>';
					_result.title=lang.subscript;
					_result.className='ui-wysiwyg-script';
					_result.icon=null;
					_result.tag='SUB';
				break;

				case 'insertImage':
					_result.text=lang.insertimage;
					_result.className='';
					_result.icon={icons: { primary: "ui-icon-image"}, text: false};
					_result.tag='IMG';
				break;

				case 'removeFormat':
					_result.text=lang.rm;
					_result.className='';
					_result.icon={icons: { primary: "ui-icon-pencil"}, text: false};
					_result.tag='';
				break;

				default:
					_result.text=type;
					_result.className='';
					_result.icon=null;
					_result.tag=null;
			}
			return _result;
		}

		// button dialogs (links/images)
		function fnRunDialog(type){
			switch(type){
				case 'createlink':
					$('<div/>', {'title': lang.inserturl}).dialog({
						autoOpen: true,
						modal: true,
						buttons: {
							"Ok": function() {
								fnRunCommand(type, $(this).find('input').val());
								$(this).dialog("close");
								return false;
							},
							"Cancel": function() {
								$(this).dialog("close");
							}
						},
						open: function() {
							var $this = $(this);
							$this.parent().find('.ui-dialog-buttonpane button:first').focus();
							$this.keypress(function(e) {
								if( e.keyCode == 13 ) {
									$this.parent().find('.ui-dialog-buttonpane button:first').click();
									return false;
								}
							});
						} 
					}).html('<input type="text" value="http://"/>');
				break;	

				case 'insertImage':
					$('<div/>', {'title': lang.insertimage}).dialog({
						autoOpen: true,
						modal: true,
						buttons: {
							"Ok": function() {
								fnRunCommand(type, $(this).find('input').val());
								$(this).dialog("close");
								return false;
							},
							"Cancel": function() {
								$(this).dialog("close");
							}
						},
						open: function() {
							var $this = $(this);
							$this.parent().find('.ui-dialog-buttonpane button:first').focus();
							$this.keypress(function(e) {
								if( e.keyCode == 13 ) {
									$this.parent().find('.ui-dialog-buttonpane button:first').click();
									return false;
								}
							});
						} 
					}).html('<input type="text" value="http://"/>');
				break;
			}
		}

		// execute a execCommand
		function fnRunCommand(cmd, val){
			// if command is ran lets hide the menus
			$('.ui-wysiwyg-dropdown').hide();
			var contentWindow = editor.contentWindow;
			contentWindow.focus();
			contentWindow.document.execCommand(cmd, false, val);
			contentWindow.focus();

			fnSyncContents();
			return false;
		}

		// execute a command, either run dialog or run command
		function fnExecCommand (e) {
			var _ignore=['createlink', 'unlink', 'insertImage', 'removeFormat', 'html'];

			if($(this).data('class')) $(_wrapper).find('.'+$(this).data('class')).removeClass('ui-state-active ui-state-focus');
			if(jQuery.inArray($(this).data('commandName'), _ignore) == -1) $(this).toggleClass('ui-state-active ui-state-focus');

			switch($(this).data('commandName')){
				case 'html':
					$('#'+_id+'-editor').toggle();
					$(_wrapper).find('.ui-wysiwyg-html').toggle();
					$(_wrapper).find('.ui-wysiwyg-btn').toggle();
					$(_wrapper).find('.ui-wysiwyg-btn-html').show();
					fnSyncContentsFromHTML();
				break;
				case 'createlink':
					return fnRunDialog($(this).data('commandName'));
				break;
				case 'insertImage':
					return fnRunDialog($(this).data('commandName'));
				break;

				default:
					return fnRunCommand($(this).data('commandName'), '');
			}
		}
		function fnSyncContents(){
			var _code=$(_wrapper).find('.ui-wysiwyg-content').contents().find('body').html();
			$('#'+_id).val(_code);
			$(_wrapper).find('.ui-wysiwyg-html').val(_code);
		}

		function fnSyncContentsFromHTML(){
			var _code=$(_wrapper).find('.ui-wysiwyg-html').val();
			$(_wrapper).find('.ui-wysiwyg-content').contents().find('body').html(_code);
			$('#'+_id).val(_code);
		}
		
		function fnSetlanguage(language, _languagelink){
			$('.ui-wysiwyg-dropdown').hide();
			var pramukh = 'pramukhindic';
			if(language == 'english'){
				pramukh = '';
			}
			
		//	alert(editor.id);
			
			pramukhIME.setLanguage(language, pramukh);
			//_languagelink[0].text ("changed");
			editor.contentWindow.focus();
		}

		$.cssHooks.backgroundColor = {
			get: function(elem) {
				if (elem.currentStyle)
					var bg = elem.currentStyle["background-color"];
				else if (window.getComputedStyle)
					var bg = document.defaultView.getComputedStyle(elem,
						null).getPropertyValue("background-color");
				if (bg.search("rgb") == -1)
					return bg;
				else {
					bg = bg.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
					function hex(x) {
						return ("0" + parseInt(x).toString(16)).slice(-2);
					}
				   if(!bg) return false; 
					return "#" + hex(bg[1]) + hex(bg[2]) + hex(bg[3]);
				}
			}
		}

    });
};

})( jQuery );