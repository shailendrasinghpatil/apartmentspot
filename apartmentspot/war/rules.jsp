
<div>Select language <select id="drpLanguage"
						onchange="javascript:changeLanguage(this.options[this.selectedIndex].value);" 
						name="drpLanguage" title="Choose Language" class="big">
						<option value=':'>--Pramukh Indic--</option>
<option value='pramukhindic:assamese'>Assamese</option>
<option value='pramukhindic:bengali'>Bengali</option>
<option value='pramukhindic:bodo'>Bodo</option>
<option value='pramukhindic:dogri'>Dogri</option>
<option value='pramukhindic:gujarati'>Gujarati</option>
<option value='pramukhindic:hindi'>Hindi</option>
<option value='pramukhindic:kannada'>Kannada</option>
<option value='pramukhindic:konkani'>Konkani</option>
<option value='pramukhindic:maithili'>Maithili</option>
<option value='pramukhindic:malayalam'>Malayalam</option>
<option value='pramukhindic:manipuri'>Manipuri</option>
<option value='pramukhindic:marathi'>Marathi</option>
<option value='pramukhindic:nepali'>Nepali</option>
<option value='pramukhindic:oriya'>Oriya</option>
<option value='pramukhindic:punjabi'>Punjabi</option>
<option value='pramukhindic:sanskrit'>Sanskrit</option>
<option value='pramukhindic:santali'>Santali</option>
<option value='pramukhindic:sindhi'>Sindhi</option>
<option value='pramukhindic:tamil'>Tamil</option>
<option value='pramukhindic:telugu'>Telugu</option>

						<option value=":english" selected="selected">English (F9)</option>
				</select> &nbsp;&nbsp;
                    <a href="#" onclick="javascript:showHelp(this);" id="cmdhelp" title="Typing help"></a>
                    </div>
        <div id="dialog-help">
                
                    <p id="pramukhimehelpquick">
                        Pramukh Type Pad is used for typing easily into Indian languages. It follows 'The way you speak, the way you type' rule. 
                        Following image shows which character will be shown by pressing which corresponding English letter. 
                        Example for various combination of letters are given only for one character but it is true for each alphabet.<br />
                        <div style="text-align:center;">
                            <img src="img/pramukhime-english.png" alt="character map" id="pramukhimecharmap" />
                        </div>
                    </p>
            </div>        
            <div>
<textarea id="juirte_editor1">

</textarea>
</div>


<script type="text/javascript">

$(document).ready(function(){
	$("#dialog-help").dialog({
		autoOpen : false,
		modal : true,
		width: 600,
		buttons : {
			Ok : function() {
				$(this).dialog("close");
			}
		}
	});	
	$('textarea').juirte({'width': '900px', 'height': '250px' ,'stylesheet': "css/themes/<%=(String)session.getAttribute("defaultTheme")%>/jquery-ui.css"});
	var iframes = document.getElementsByTagName('iframe');
	pramukhIME.addLanguage(PramukhIndic);
	for (var i = 0, len = iframes.length, doc; i < len; ++i) {
		
		doc = iframes[i].contentDocument || iframes[i].contentWindow.document;
		//alert(doc.designMode);
		doc.designMode = "on";
		pramukhIME.enable(iframes[i].id);

	}
	
	pramukhIME.enable();
	pramukhIME.onLanguageChange(scriptChangeCallback);
	var lang = (getCookie('pramukhime_language',':english')).split(':');
	pramukhIME.setLanguage(lang[1], lang[0]);
	
});

</script>