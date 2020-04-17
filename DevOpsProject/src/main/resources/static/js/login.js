$(document).ready(function() {
	
	if(dbMsg.includes("successfully")){
		$('#alertMsgText').html('<strong>'+dbMsg+'!</strong>');
		$('#alertMsg').addClass('success');
		$('#alertMsg').css('display','block');
	}
	if(dbMsg.includes("Error")){
		$('#alertMsgText').html('<strong>'+dbMsg+'!</strong>');
		$('#alertMsg').css('display','block');
	}
	if($('#usrname').val()!=''){
		$('#usrname').val('');
	}
	if($('#usrpwd').val()!=''){
		$('#usrpwd').val('');
	}
	if($('#password').val()!=''){
		$('#password').val('');
	}
});


function validateRegisterForm() {
	let pwd = $('#usrpwd').val();
	let cnfPwd = $('#usrcnfpwd').val();
	if(pwd != cnfPwd){
		//alert('Password and confirm password did not match!');
		$('#alertMsgText').html('<strong>Password and confirm password did not match!</strong>');
		$('#alertMsg').css('display','block');
		return false;
	}
	
	var maxUploadSize = 65535;
	var validExtensions = ['jpg']; //array of valid extensions
	var imageName=($('#usrimage')[0].files[0].name);
	var imageSize=($('#usrimage')[0].files[0].size);
	var imageNameExt = imageName.substr(imageName.lastIndexOf('.') + 1);
	//alert(imageName +":::"+imageSize);
		        
	if ($.inArray(imageNameExt, validExtensions) == -1){
	   	$('#alertMsgText').html('<strong>Only JPEG is allowed!</strong>');
	 	$('#alertMsg').css('display','block');
	 	$('#usrimage').val('');
		return false;
		}
		        
	if(imageSize > maxUploadSize) {
	    $('#alertMsgText').html('<strong>Image size can not be greater than 65 KB!</strong>');
		$('#alertMsg').css('display','block');
		$('#usrimage').val('');
		return false;
		};
}