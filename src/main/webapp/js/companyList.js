var api = "webapi/organisation/getOrganisations";
//alert("companyList");
$.get(api, function (organisation, status) {
    // alert("inFuc");
    if (status == "success") {
        // alert("good");
        var organisation_data_body = "";
        for (var i = 0; i < organisation.length; i++) {
            organisation_data_body += '<tr>'
                + '<td>' + organisation[i].oID + '</td>'
                + '<td>' + organisation[i].name + '</td>'
                +'<td>' + '<a href= "/academic_erp_war_exploded/studentlist.html" onclick="passOID('+ organisation[i].oID +')">View</a> '+'</td>'
                 + '</tr>';
        }
        $('#organisation_data tbody').html(organisation_data_body);
    }
    $('#organisation_data').DataTable();
});

function passOID(oID) {
    if (typeof(Storage) !== "undefined") {
        sessionStorage.setItem("oID", oID);
    } else {
        document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
    }
}
