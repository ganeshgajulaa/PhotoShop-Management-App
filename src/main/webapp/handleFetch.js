const handleFetch = (event) => {
  //event.preventDefault();
    console.log("inside handlefetch js");
    
    const name= document.querySelector("#name");
    const customerId= document.querySelector("#customerId");
    const nameLabel= document.querySelector("#nameLabel");
    const customerIdLabel= document.querySelector("#customerIdLabel");

  const mobileNum = document.querySelector("#mobileNum").value; // Get the value

  fetch("fetchData", {
    method: "POST",
    body: JSON.stringify({ mobileNum: mobileNum }) // Create a JSON object with mobileNum
  })
  .then(response => response.json())
  .then(data => {
	nameLabel.textContent=data.name;
	customerIdLabel.textContent =data.id;
	name.value=data.name;
	customerId.value =data.id;
    console.log(name.value);
    console.log(customerId.value);
    
    console.log(data);    
    //name.value=data.name;
  })
  .catch(error => {
      console.error(error);
  })

}
