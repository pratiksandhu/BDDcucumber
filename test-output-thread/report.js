$(document).ready(function() {
CucumberHTML.timelineItems.pushArray([
  {
    "id": "154f0ac2-0f69-4b92-935c-26827ef77e59",
    "feature": "Crm login",
    "scenario": "login into crm account",
    "start": 1693966684973,
    "group": 19,
    "content": "",
    "tags": "",
    "end": 1693966689541,
    "className": "passed"
  },
  {
    "id": "7a520ce3-f70b-4f5d-bace-263740623f58",
    "feature": "test afterSignInPage",
    "scenario": "test contacts page",
    "start": 1693966684972,
    "group": 17,
    "content": "",
    "tags": "",
    "end": 1693966705915,
    "className": "failed"
  },
  {
    "id": "3cecf777-8872-4813-a9b6-5fdfc6004a86",
    "feature": "test afterSignInPage",
    "scenario": "test deals page",
    "start": 1693966684973,
    "group": 18,
    "content": "",
    "tags": "@deals,",
    "end": 1693966699644,
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