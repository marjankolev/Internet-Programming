$(function(){
	var kosnicka = $("nav ul li a span");
	var dodaj = $("article footer button:last-child");
	var total;

	var link_kosnicka = $("header > nav ul li:last-child");

	var lista = $(".proizvodi_lista");

	lista.hide();
	$(".popup").hide();

	if(kosnicka.html()==""){
		kosnicka.hide();
		total = 0;
	}

	dodaj.click(function(){
		total++;
		kosnicka.html(total);
		kosnicka.show();

		var naslov = $(this).parent().parent().children("header").html().split("<")[0];
		$(".popup").hide();
		$(".popup").html("Додадено во кошничка");
		$(".popup").css({'background-color':'#0f0'});
		$(".popup").show().delay(1200).fadeOut();

		lista.append("<p class='item'>"+naslov+"</p>");
	});


	link_kosnicka.click(function(){
		if(total==0)
		{
			$(".popup").html("Додадете барем еден производ во кошничката!");
			$(".popup").css({'background-color':'#f00'});
			$(".popup").show().delay(3000).fadeOut();
			return false;
		}
		else{
			$(".sodrzina").html("");
			$(".sodrzina").append("<h1>Кошничка</h1>");
			$(".sodrzina").append("<hr>");
			$(".sodrzina").append("<div class='proizvodi_lista'>"+lista.html()+"</div>");
			$(".sodrzina").append("<br>");
			$(".sodrzina").append("<button class='naraci_se' onclick='naraci()'>Нарачи се</button>")
		}
	});
});

function naraci(){
	window.location.href = "naracaj.html";
}