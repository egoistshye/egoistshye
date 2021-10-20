function validateForm() {
  var x = document.forms["myForm"]["fname"].value;
  var y = document.forms["myForm"]["lname"].value;
  var z = document.forms["myForm"]["email"].value;
    
  if (x == "") {
    alert("Please fill out the first name field.");

  } if (y == "") {
    alert("Please fill out the last name field.");
  }

  return false;

}