import React from 'react';

const url = 'https://cloud-test-350616.oa.r.appspot.com';

export async function generateNumers() {
    console.log("Calling Generating numbers API"); 
        fetch(url+"/generate", {
            method: 'POST',
        }).then(response => response.json()).then(data => {
            Object.entries(data).forEach(([key, value]) => {
                console.log(`${key}: ${value}`);
            });
        });
}

export async function getAllResults() {
    console.log("Fetching all results from DB");
    fetch(url+"/get-results", {
        method: "GET",
    }).then(response => response.json()).then(data => {
        data.forEach((element) => {
            console.log(`Instance name: ${element.instance}, Largest Value: ${element.largest}, Smallest Value: ${element.smallest}`);
        });
    });
}

export async function getLargest() {
    console.log("Fetching Largest Number");
    fetch(url+"/get-largest", {
        method: "GET",
    }).then(response => response.json()).then(data => {
        console.log(`Instance Name: ${data['Instance Name: ']}, Largest Value: ${data['Largest Value: ']}`);
    });
}

export async function getSmallest() {
    console.log("Fetching Smallest Number");
    fetch(url+"/get-smallest", {
        method: "GET",
    }).then(response => response.json()).then(data => {
        console.log(`Instance Name: ${data['Instance Name: ']}, Smallest Value: ${data['Smallest Value: ']}`);
    });
}

export async function clearDatabase() {
    console.log("Clearing Database");
    fetch(url+"/clear", {
        method: "POST",
    }).then(response => response.text()).then(data => console.log(data));
}


export async function googleTest() {
    console.log("Basic Test");
    for (let i = 0; i < 3; i++) { 
    fetch(url+"/", {
        method: "GET",
    }).then(response => response.text()).then(data => console.log(data));
}
}


