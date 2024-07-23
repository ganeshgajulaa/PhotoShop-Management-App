let count = 0;

function handleAddFamily() {
    count++;

    const container = document.querySelector('#addMember');

    const containerInnerDiv = document.createElement('div');

    const formRowDiv1 = document.createElement('div');
    formRowDiv1.classList.add('form-row');

    // Member Name
    const inputDataDiv1 = document.createElement('div');
    inputDataDiv1.classList.add('input-data');

    const memberName = document.createElement('input');
    memberName.setAttribute('type', 'text');
    memberName.setAttribute('name', 'memberName' + count);
    memberName.setAttribute('id', 'memberName' + count);
    memberName.required = true;

    const underlineDiv1 = document.createElement('div');
    underlineDiv1.classList.add('underline');

    inputDataDiv1.appendChild(memberName);
    inputDataDiv1.appendChild(underlineDiv1);

    // Member Relation
    const inputDataDiv2 = document.createElement('div');
    inputDataDiv2.classList.add('input-data');

    const memberRelation = document.createElement('input');
    memberRelation.setAttribute('type', 'text');
    memberRelation.setAttribute('name', 'memberRelation' + count);
    memberRelation.setAttribute('id', 'memberRelation' + count);
    memberRelation.required = true;

    const underlineDiv2 = document.createElement('div');
    underlineDiv2.classList.add('underline');

    inputDataDiv2.appendChild(memberRelation);
    inputDataDiv2.appendChild(underlineDiv2);    
    
    const formRowDiv2 = document.createElement('div');
    formRowDiv2.classList.add('form-row');

    // Member Date of Birth Label
    const inputDataDiv3 = document.createElement('div');
    inputDataDiv3.classList.add('input-data');    

    const memberDobLabel = document.createElement('label');
    memberDobLabel.setAttribute('for', 'memberDob' + count);
    memberDobLabel.innerHTML = 'Member Date of Birth';

    inputDataDiv3.appendChild(memberDobLabel);

    // Member Date of Birth Input
    const inputDataDiv4 = document.createElement('div');
    inputDataDiv4.classList.add('input-data');

    const dobInput4 = document.createElement('input');
    dobInput4.setAttribute('type', 'date');
    dobInput4.setAttribute('name', 'memberDob' + count);
    dobInput4.setAttribute('id', 'memberDob' + count);
    dobInput4.required = true;

    const underlineDiv3 = document.createElement('div');
    underlineDiv3.classList.add('underline');

    inputDataDiv4.appendChild(dobInput4);
    inputDataDiv4.appendChild(underlineDiv3);

    // Append inputData class divs to form rows
    formRowDiv1.appendChild(inputDataDiv1);
    formRowDiv1.appendChild(inputDataDiv2);
    formRowDiv2.appendChild(inputDataDiv3);
    formRowDiv2.appendChild(inputDataDiv4);

    // Append form rows to innerDiv
    containerInnerDiv.appendChild(formRowDiv1);
    containerInnerDiv.appendChild(formRowDiv2);

    // Append innerDiv to container
    container.appendChild(containerInnerDiv);    
    
    // Update memberCount hidden input
    document.querySelector("#memberCount").value = count;
}
