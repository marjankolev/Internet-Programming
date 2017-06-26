function getItems()
{
	var proizvodi = [];

	for(i=1; i<=8; i++)
	{
		laptop = getCookie(i+"laptop");
		tablet = getCookie(i+"tablet");
		mobilen = getCookie(i+"mobilen");
		kamera = getCookie(i+"kamera");
		zvucnik = getCookie(i+"zvucnik");

		if(laptop!="")
			proizvodi.push(laptop);

		if(tablet!="")
			proizvodi.push(tablet);
		
		if(mobilen!="")
			proizvodi.push(mobilen);

		if(kamera!="")
			proizvodi.push(kamera);

		if(zvucnik!="")
			proizvodi.push(zvucnik);
	}

	for(i=0; i<proizvodi.length; i++)
	{
		kreirajElement("li","lista",proizvodi[i]);
	}
	
	kreirajElement("button","kopce","Нарачај");

	deleteItem();

	var naraci = document.getElementsByTagName("button");

	naraci[0].onclick = function(){
		window.location.href = "naracaj.html";
	}
}

function kreirajElement(tip,lista,tekst)
{
	var node = document.createElement(tip);                 
	var textnode = document.createTextNode(tekst);      
	node.appendChild(textnode);         
	if(tip=="li"){
		var att = document.createAttribute("class"); 
		att.value = "proizvod";                           
		node.setAttributeNode(att);                      
	}
	document.getElementById(lista).appendChild(node);
}


function deleteItem(){
	var proizvod = document.getElementsByClassName("proizvod");	
	for (i = 0; i < proizvod.length; i++) {
	  proizvod[i].onclick = function() {console.log(1); this.parentNode.removeChild(this);}
	}
}


