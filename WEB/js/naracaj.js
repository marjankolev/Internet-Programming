function naracaj()
{
  var ime = document.getElementById("ime");
  var email = document.getElementById("email");
  var tel = document.getElementById("tel");
  var adresa = document.getElementById("adresa");

  var greski = document.getElementById("greski");

  if(ime.value=="" || email.value=="" || tel.value=="" || adresa.value=="")
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
  else if(validirajTel(tel)===false)
  {
    greski.innerHTML="Внесовте невалиден формат на телефонски број (07x-xxx-xxx)!";
    greski.style.display = "block";
    return false;
  }
  else
  {
    greski.innerHTML="";
    greski.style.display = "none";
    alert("Нарачката е успешна");
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

function validirajTel(tel)
{
  regex = /^07[0-9]-[1-9]{3}-[0-9]{3}$/;
  if (regex.test(tel.value)) 
  {
    return true;
  }
  else
  {
    return false;
  }
}