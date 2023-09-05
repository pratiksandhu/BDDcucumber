$(document).ready(function() {
CucumberHTML.timelineItems.pushArray([
  {
    "id": "4a631426-ea77-4d57-9e46-6d946b52aa41",
    "feature": "test afterSignInPage",
    "scenario": "test contacts page",
    "start": 1693945420691,
    "group": 17,
    "content": "",
    "tags": "",
    "end": 1693945441627,
    "className": "passed"
  },
  {
    "id": "39741b19-136a-4918-9efb-f4d332f640ad",
    "feature": "Crm login",
    "scenario": "login into crm account",
    "start": 1693945420715,
    "group": 19,
    "content": "",
    "tags": "",
    "end": 1693945426071,
    "className": "passed"
  },
  {
    "id": "bae2197e-0c24-4ba4-85dd-31eeb3463842",
    "feature": "test afterSignInPage",
    "scenario": "test deals page",
    "start": 1693945420690,
    "group": 18,
    "content": "",
    "tags": "@deals,",
    "end": 1693945436532,
    "className": "failed"
  }
]);
CucumberHTML.timelineGroups.pushArray([
  {
    "id": 17,
    "content": "Thread[TestNG-PoolService-0,5,main]"
  },
  {
    "id": 18,
    "content": "Thread[TestNG-PoolService-1,5,main]"
  },
  {
    "id": 19,
    "content": "Thread[TestNG-PoolService-2,5,main]"
  }
]);
});