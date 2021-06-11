/**
 *
 */
 	 var passInput = $('#js-password');
		    var passVisible = $('<input type="text" value="" name="PW" id="password_visible" />');
		    var passCheck = $('<input type="checkbox" />');

		jQuery(function($){
			    passInput.after(passCheck);
			    passCheck.click(function(){
			        if(this.checked){
			        	passInput.replaceWith(passVisible.val(passInput.val()));
			        }else{
			        	passVisible.replaceWith(passInput.val(passVisible.val()));
			        }
			    });
			});