function validate(){
	var name = document.getElementById('name').value;
	if(name == ''){
		alert("Please enter name");
		return false;
	}
}