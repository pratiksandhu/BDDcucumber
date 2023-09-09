$(document).ready(function() {
CucumberHTML.timelineItems.pushArray([
  {
    "id": "dd520070-fb39-46c7-afd0-6263df6b9559",
    "feature": "Crm login",
    "scenario": "login into crm account",
    "start": 1694240681702,
    "group": 19,
    "content": "",
    "tags": "@regression,",
    "end": 1694240685633,
    "className": "passed"
  },
  {
    "id": "1b7d6d73-7f06-4b6f-b387-6f1d736c80c1",
    "feature": "test afterSignInPage",
    "scenario": "test contacts page",
    "start": 1694240681675,
    "group": 17,
    "content": "",
    "tags": "@smoke,",
    "end": 1694240702421,
    "className": "failed"
  },
  {
    "id": "f38700a6-47e0-4df7-8383-cb40027a4c33",
    "feature": "test afterSignInPage",
    "scenario": "test deals page",
    "start": 1694240681675,
    "group": 18,
    "content": "",
    "tags": "@smoke,",
    "end": 1694240696782,
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