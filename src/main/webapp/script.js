/**
 * 
 */

document.getElementById("proverb").innerText = " Quotes here...";

 function getProverbs(){
	 document.getElementById("proverb").innerText = " Loading...";
	 var xhr = new XMLHttpRequest();
	 
	 xhr.onreadystatechange = () => {
		 if(xhr.readyState == 4 && xhr.status == 200){
				 var json = JSON.parse(xhr.responseText);
				 if(json.statusCode == 200){
				 document.getElementById("proverb").innerText = json.quote;
				
			 }
		 }
	 }
	 var category = document.getElementById("category").value;
	 xhr.open("POST", "http://localhost:8080/Proverbs_API/Proverb");
	 xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");	 
	 xhr.send("category=" + category);
	 
	 
 }