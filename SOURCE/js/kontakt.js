function ispratiPoraka()
{
  var ime = document.getElementById("ime");
  var email = document.getElementById("email");
  var naslov = document.getElementById("naslov");
  var poraka = document.getElementById("poraka");

  var greski = document.getElementById("greski");

  if(ime.value=="" || email.value=="" || naslov.value=="" || poraka.value=="")
  {
    greski.innerHTML="Сите полиња се задолжителни!";
    greski.style.display = "block";
    return false;
  }
  else if(validirajEmail(email)===false)
  {
    greski.innerHTML="Внесовте невалиден емаил!";
    greski.style.display = "block";
    return false;
  }
  else
  {
    greski.innerHTML="";
    greski.style.display = "none";
    window.location.href="mailto:seminarska_ip2015@hotmail.com?subject="+naslov+"&body="+poraka+"&from="+email;
  }

}

function validirajEmail(email)
{
  regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if (regex.test(email.value)) 
  {
    return true;
  }
  else
  {
    return false;
  }
}