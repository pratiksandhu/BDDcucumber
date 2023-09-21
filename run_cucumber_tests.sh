#!/bin/bash
feature_file=$1
mvn test -Dbrowser=${TEST_BROWSER} -Dcucumber.features="$feature_file"  -Dcucumber.filter.tags="@Regression or @Smoke" -Dcucumber.plugin="json:target/cucumber-report.json,junit:target/cucumber-report.xml"
