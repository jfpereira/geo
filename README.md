# geo
Para testar:
    arrancar a aplicação (springboot - autoconfiguravel no intelij)
    utilisar ferramenta para efetuar pedidos(ex postman)
    url de teste: https://localhost:8081/info
    passar body json com o seguinte formato:
        {
            "countryName" : "PT"
        }
    resultado esperado um JSON com o seguinte formato:
    {
        "countryName": "Portugal",
        "isoNumeric": "620",
        "isoAlpha3": "PRT",
        "fipsCode": "PO",
        "continent": "EU",
        "continentName": "Europe",
        "capital": "Lisbon",
        "areaInSqKm": "92391.0",
        "population": "10281762",
        "currencyCode": "EUR",
        "languages": "pt-PT,mwl",
        "geonameId": "2264397",
        "west": "-9.50052660716588",
        "north": "42.154311127408",
        "east": "-6.18915930748288",
        "south": "36.96125",
        "postalCodeFormat": "####-###"
    }


