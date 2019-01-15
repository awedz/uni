function GetCountry() {
    userInput = document.getElementById("txtIRange").value;
    console.log(userInput)
    table = document.getElementById("resTable");
    for (var i = 0;i<list.length;i++) {
        if (parseInt(list[i].population) <= parseInt(userInput)) {
            var row = table.insertRow(0);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            cell1.innerHTML = list[i].name;
            cell2.innerHTML = list[i].population;
        }
    }
}






list = [{
    "name": "Afghanistan",
    "population": 27657145
}, {
    "name": "Åland Islands",
    "population": 28875
}, {
    "name": "Albania",
    "population": 2886026
}, {
    "name": "Algeria",
    "population": 40400000
}, {
    "name": "American Samoa",
    "population": 57100
}, {
    "name": "Andorra",
    "population": 78014
}, {
    "name": "Angola",
    "population": 25868000
}, {
    "name": "Anguilla",
    "population": 13452
}, {
    "name": "Antarctica",
    "population": 1000
}, {
    "name": "Antigua and Barbuda",
    "population": 86295
}, {
    "name": "Argentina",
    "population": 43590400
}, {
    "name": "Armenia",
    "population": 2994400
}, {
    "name": "Aruba",
    "population": 107394
}, {
    "name": "Australia",
    "population": 24117360
}, {
    "name": "Austria",
    "population": 8725931
}, {
    "name": "Azerbaijan",
    "population": 9730500
}, {
    "name": "Bahamas",
    "population": 378040
}, {
    "name": "Bahrain",
    "population": 1404900
}, {
    "name": "Bangladesh",
    "population": 161006790
}, {
    "name": "Barbados",
    "population": 285000
}, {
    "name": "Belarus",
    "population": 9498700
}, {
    "name": "Belgium",
    "population": 11319511
}, {
    "name": "Belize",
    "population": 370300
}, {
    "name": "Benin",
    "population": 10653654
}, {
    "name": "Bermuda",
    "population": 61954
}, {
    "name": "Bhutan",
    "population": 775620
}, {
    "name": "Bolivia (Plurinational State of)",
    "population": 10985059
}, {
    "name": "Bonaire, Sint Eustatius and Saba",
    "population": 17408
}, {
    "name": "Bosnia and Herzegovina",
    "population": 3531159
}, {
    "name": "Botswana",
    "population": 2141206
}, {
    "name": "Bouvet Island",
    "population": 0
}, {
    "name": "Brazil",
    "population": 206135893
}, {
    "name": "British Indian Ocean Territory",
    "population": 3000
}, {
    "name": "United States Minor Outlying Islands",
    "population": 300
}, {
    "name": "Virgin Islands (British)",
    "population": 28514
}, {
    "name": "Virgin Islands (U.S.)",
    "population": 114743
}, {
    "name": "Brunei Darussalam",
    "population": 411900
}, {
    "name": "Bulgaria",
    "population": 7153784
}, {
    "name": "Burkina Faso",
    "population": 19034397
}, {
    "name": "Burundi",
    "population": 10114505
}, {
    "name": "Cambodia",
    "population": 15626444
}, {
    "name": "Cameroon",
    "population": 22709892
}, {
    "name": "Canada",
    "population": 36155487
}, {
    "name": "Cabo Verde",
    "population": 531239
}, {
    "name": "Cayman Islands",
    "population": 58238
}, {
    "name": "Central African Republic",
    "population": 4998000
}, {
    "name": "Chad",
    "population": 14497000
}, {
    "name": "Chile",
    "population": 18191900
}, {
    "name": "China",
    "population": 1377422166
}, {
    "name": "Christmas Island",
    "population": 2072
}, {
    "name": "Cocos (Keeling) Islands",
    "population": 550
}, {
    "name": "Colombia",
    "population": 48759958
}, {
    "name": "Comoros",
    "population": 806153
}, {
    "name": "Congo",
    "population": 4741000
}, {
    "name": "Congo (Democratic Republic of the)",
    "population": 85026000
}, {
    "name": "Cook Islands",
    "population": 18100
}, {
    "name": "Costa Rica",
    "population": 4890379
}, {
    "name": "Croatia",
    "population": 4190669
}, {
    "name": "Cuba",
    "population": 11239004
}, {
    "name": "Curaçao",
    "population": 154843
}, {
    "name": "Cyprus",
    "population": 847000
}, {
    "name": "Czech Republic",
    "population": 10558524
}, {
    "name": "Denmark",
    "population": 5717014
}, {
    "name": "Djibouti",
    "population": 900000
}, {
    "name": "Dominica",
    "population": 71293
}, {
    "name": "Dominican Republic",
    "population": 10075045
}, {
    "name": "Ecuador",
    "population": 16545799
}, {
    "name": "Egypt",
    "population": 91290000
}, {
    "name": "El Salvador",
    "population": 6520675
}, {
    "name": "Equatorial Guinea",
    "population": 1222442
}, {
    "name": "Eritrea",
    "population": 5352000
}, {
    "name": "Estonia",
    "population": 1315944
}, {
    "name": "Ethiopia",
    "population": 92206005
}, {
    "name": "Falkland Islands (Malvinas)",
    "population": 2563
}, {
    "name": "Faroe Islands",
    "population": 49376
}, {
    "name": "Fiji",
    "population": 867000
}, {
    "name": "Finland",
    "population": 5491817
}, {
    "name": "France",
    "population": 66710000
}, {
    "name": "French Guiana",
    "population": 254541
}, {
    "name": "French Polynesia",
    "population": 271800
}, {
    "name": "French Southern Territories",
    "population": 140
}, {
    "name": "Gabon",
    "population": 1802278
}, {
    "name": "Gambia",
    "population": 1882450
}, {
    "name": "Georgia",
    "population": 3720400
}, {
    "name": "Germany",
    "population": 81770900
}, {
    "name": "Ghana",
    "population": 27670174
}, {
    "name": "Gibraltar",
    "population": 33140
}, {
    "name": "Greece",
    "population": 10858018
}, {
    "name": "Greenland",
    "population": 55847
}, {
    "name": "Grenada",
    "population": 103328
}, {
    "name": "Guadeloupe",
    "population": 400132
}, {
    "name": "Guam",
    "population": 184200
}, {
    "name": "Guatemala",
    "population": 16176133
}, {
    "name": "Guernsey",
    "population": 62999
}, {
    "name": "Guinea",
    "population": 12947000
}, {
    "name": "Guinea-Bissau",
    "population": 1547777
}, {
    "name": "Guyana",
    "population": 746900
}, {
    "name": "Haiti",
    "population": 11078033
}, {
    "name": "Heard Island and McDonald Islands",
    "population": 0
}, {
    "name": "Holy See",
    "population": 451
}, {
    "name": "Honduras",
    "population": 8576532
}, {
    "name": "Hong Kong",
    "population": 7324300
}, {
    "name": "Hungary",
    "population": 9823000
}, {
    "name": "Iceland",
    "population": 334300
}, {
    "name": "India",
    "population": 1295210000
}, {
    "name": "Indonesia",
    "population": 258705000
}, {
    "name": "Côte d'Ivoire",
    "population": 22671331
}, {
    "name": "Iran (Islamic Republic of)",
    "population": 79369900
}, {
    "name": "Iraq",
    "population": 37883543
}, {
    "name": "Ireland",
    "population": 6378000
}, {
    "name": "Isle of Man",
    "population": 84497
}, {
    "name": "Israel",
    "population": 8527400
}, {
    "name": "Italy",
    "population": 60665551
}, {
    "name": "Jamaica",
    "population": 2723246
}, {
    "name": "Japan",
    "population": 126960000
}, {
    "name": "Jersey",
    "population": 100800
}, {
    "name": "Jordan",
    "population": 9531712
}, {
    "name": "Kazakhstan",
    "population": 17753200
}, {
    "name": "Kenya",
    "population": 47251000
}, {
    "name": "Kiribati",
    "population": 113400
}, {
    "name": "Kuwait",
    "population": 4183658
}, {
    "name": "Kyrgyzstan",
    "population": 6047800
}, {
    "name": "Lao People's Democratic Republic",
    "population": 6492400
}, {
    "name": "Latvia",
    "population": 1961600
}, {
    "name": "Lebanon",
    "population": 5988000
}, {
    "name": "Lesotho",
    "population": 1894194
}, {
    "name": "Liberia",
    "population": 4615000
}, {
    "name": "Libya",
    "population": 6385000
}, {
    "name": "Liechtenstein",
    "population": 37623
}, {
    "name": "Lithuania",
    "population": 2872294
}, {
    "name": "Luxembourg",
    "population": 576200
}, {
    "name": "Macao",
    "population": 649100
}, {
    "name": "Macedonia (the former Yugoslav Republic of)",
    "population": 2058539
}, {
    "name": "Madagascar",
    "population": 22434363
}, {
    "name": "Malawi",
    "population": 16832910
}, {
    "name": "Malaysia",
    "population": 31405416
}, {
    "name": "Maldives",
    "population": 344023
}, {
    "name": "Mali",
    "population": 18135000
}, {
    "name": "Malta",
    "population": 425384
}, {
    "name": "Marshall Islands",
    "population": 54880
}, {
    "name": "Martinique",
    "population": 378243
}, {
    "name": "Mauritania",
    "population": 3718678
}, {
    "name": "Mauritius",
    "population": 1262879
}, {
    "name": "Mayotte",
    "population": 226915
}, {
    "name": "Mexico",
    "population": 122273473
}, {
    "name": "Micronesia (Federated States of)",
    "population": 102800
}, {
    "name": "Moldova (Republic of)",
    "population": 3553100
}, {
    "name": "Monaco",
    "population": 38400
}, {
    "name": "Mongolia",
    "population": 3093100
}, {
    "name": "Montenegro",
    "population": 621810
}, {
    "name": "Montserrat",
    "population": 4922
}, {
    "name": "Morocco",
    "population": 33337529
}, {
    "name": "Mozambique",
    "population": 26423700
}, {
    "name": "Myanmar",
    "population": 51419420
}, {
    "name": "Namibia",
    "population": 2324388
}, {
    "name": "Nauru",
    "population": 10084
}, {
    "name": "Nepal",
    "population": 28431500
}, {
    "name": "Netherlands",
    "population": 17019800
}, {
    "name": "New Caledonia",
    "population": 268767
}, {
    "name": "New Zealand",
    "population": 4697854
}, {
    "name": "Nicaragua",
    "population": 6262703
}, {
    "name": "Niger",
    "population": 20715000
}, {
    "name": "Nigeria",
    "population": 186988000
}, {
    "name": "Niue",
    "population": 1470
}, {
    "name": "Norfolk Island",
    "population": 2302
}, {
    "name": "Korea (Democratic People's Republic of)",
    "population": 25281000
}, {
    "name": "Northern Mariana Islands",
    "population": 56940
}, {
    "name": "Norway",
    "population": 5223256
}, {
    "name": "Oman",
    "population": 4420133
}, {
    "name": "Pakistan",
    "population": 194125062
}, {
    "name": "Palau",
    "population": 17950
}, {
    "name": "Palestine, State of",
    "population": 4682467
}, {
    "name": "Panama",
    "population": 3814672
}, {
    "name": "Papua New Guinea",
    "population": 8083700
}, {
    "name": "Paraguay",
    "population": 6854536
}, {
    "name": "Peru",
    "population": 31488700
}, {
    "name": "Philippines",
    "population": 103279800
}, {
    "name": "Pitcairn",
    "population": 56
}, {
    "name": "Poland",
    "population": 38437239
}, {
    "name": "Portugal",
    "population": 10374822
}, {
    "name": "Puerto Rico",
    "population": 3474182
}, {
    "name": "Qatar",
    "population": 2587564
}, {
    "name": "Republic of Kosovo",
    "population": 1733842
}, {
    "name": "Réunion",
    "population": 840974
}, {
    "name": "Romania",
    "population": 19861408
}, {
    "name": "Russian Federation",
    "population": 146599183
}, {
    "name": "Rwanda",
    "population": 11553188
}, {
    "name": "Saint Barthélemy",
    "population": 9417
}, {
    "name": "Saint Helena, Ascension and Tristan da Cunha",
    "population": 4255
}, {
    "name": "Saint Kitts and Nevis",
    "population": 46204
}, {
    "name": "Saint Lucia",
    "population": 186000
}, {
    "name": "Saint Martin (French part)",
    "population": 36979
}, {
    "name": "Saint Pierre and Miquelon",
    "population": 6069
}, {
    "name": "Saint Vincent and the Grenadines",
    "population": 109991
}, {
    "name": "Samoa",
    "population": 194899
}, {
    "name": "San Marino",
    "population": 33005
}, {
    "name": "Sao Tome and Principe",
    "population": 187356
}, {
    "name": "Saudi Arabia",
    "population": 32248200
}, {
    "name": "Senegal",
    "population": 14799859
}, {
    "name": "Serbia",
    "population": 7076372
}, {
    "name": "Seychelles",
    "population": 91400
}, {
    "name": "Sierra Leone",
    "population": 7075641
}, {
    "name": "Singapore",
    "population": 5535000
}, {
    "name": "Sint Maarten (Dutch part)",
    "population": 38247
}, {
    "name": "Slovakia",
    "population": 5426252
}, {
    "name": "Slovenia",
    "population": 2064188
}, {
    "name": "Solomon Islands",
    "population": 642000
}, {
    "name": "Somalia",
    "population": 11079000
}, {
    "name": "South Africa",
    "population": 55653654
}, {
    "name": "South Georgia and the South Sandwich Islands",
    "population": 30
}, {
    "name": "Korea (Republic of)",
    "population": 50801405
}, {
    "name": "South Sudan",
    "population": 12131000
}, {
    "name": "Spain",
    "population": 46438422
}, {
    "name": "Sri Lanka",
    "population": 20966000
}, {
    "name": "Sudan",
    "population": 39598700
}, {
    "name": "Suriname",
    "population": 541638
}, {
    "name": "Svalbard and Jan Mayen",
    "population": 2562
}, {
    "name": "Swaziland",
    "population": 1132657
}, {
    "name": "Sweden",
    "population": 9894888
}, {
    "name": "Switzerland",
    "population": 8341600
}, {
    "name": "Syrian Arab Republic",
    "population": 18564000
}, {
    "name": "Taiwan",
    "population": 23503349
}, {
    "name": "Tajikistan",
    "population": 8593600
}, {
    "name": "Tanzania, United Republic of",
    "population": 55155000
}, {
    "name": "Thailand",
    "population": 65327652
}, {
    "name": "Timor-Leste",
    "population": 1167242
}, {
    "name": "Togo",
    "population": 7143000
}, {
    "name": "Tokelau",
    "population": 1411
}, {
    "name": "Tonga",
    "population": 103252
}, {
    "name": "Trinidad and Tobago",
    "population": 1349667
}, {
    "name": "Tunisia",
    "population": 11154400
}, {
    "name": "Turkey",
    "population": 78741053
}, {
    "name": "Turkmenistan",
    "population": 4751120
}, {
    "name": "Turks and Caicos Islands",
    "population": 31458
}, {
    "name": "Tuvalu",
    "population": 10640
}, {
    "name": "Uganda",
    "population": 33860700
}, {
    "name": "Ukraine",
    "population": 42692393
}, {
    "name": "United Arab Emirates",
    "population": 9856000
}, {
    "name": "United Kingdom of Great Britain and Northern Ireland",
    "population": 65110000
}, {
    "name": "United States of America",
    "population": 323947000
}, {
    "name": "Uruguay",
    "population": 3480222
}, {
    "name": "Uzbekistan",
    "population": 31576400
}, {
    "name": "Vanuatu",
    "population": 277500
}, {
    "name": "Venezuela (Bolivarian Republic of)",
    "population": 31028700
}, {
    "name": "Viet Nam",
    "population": 92700000
}, {
    "name": "Wallis and Futuna",
    "population": 11750
}, {
    "name": "Western Sahara",
    "population": 510713
}, {
    "name": "Yemen",
    "population": 27478000
}, {
    "name": "Zambia",
    "population": 15933883
}, {
    "name": "Zimbabwe",
    "population": 14240168
}];
