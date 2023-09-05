$(document).ready(function() {
CucumberHTML.timelineItems.pushArray([
  {
    "id": "8fec6587-f6ff-4d1b-bc01-19c0629342dc",
    "feature": "Crm login",
    "scenario": "login into crm account",
    "start": 1693914208308,
    "group": 19,
    "content": "",
    "tags": "",
    "end": 1693914222653,
    "className": "passed"
  },
  {
    "id": "1a0742a0-1725-4ffb-952a-d22456abd5ae",
    "feature": "test afterSignInPage",
    "scenario": "test contacts page",
    "start": 1693914208282,
    "group": 17,
    "content": "",
    "tags": "",
    "end": 1693914238964,
    "className": "passed"
  },
  {
    "id": "ae6abb0a-e519-4637-aa5b-66d04b89b97b",
    "feature": "test afterSignInPage",
    "scenario": "test deals page",
    "start": 1693914208281,
    "group": 18,
    "content": "",
    "tags": "@deals,",
    "end": 1693914233470,
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