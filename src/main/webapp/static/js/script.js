function switchDetails(userId){
	document.getElementById("deleteAction").setAttribute("href", "delete?id=" + userId);
	document.getElementById("dialog-container").style.display = "block";
}

function closeDetails(){
	document.getElementById("dialog-container").style.display = "none";
}


