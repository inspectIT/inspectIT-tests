[![Gitter](https://img.shields.io/badge/Gitter-join%20chat-brightgreen.svg)](https://gitter.im/inspectIT/chat?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) [![Build Status](http://jenkins.inspectit.rocks/buildStatus/icon?job=inspectIT%20-%20Integration)](http://jenkins.inspectit.rocks/job/inspectIT%20-%20Integration/) [![License](https://img.shields.io/badge/License-AGPLv3--with--exception-brightgreen.svg)](https://github.com/inspectIT/inspectIT/blob/master/LICENSE.txt)

# inspectIT test project
This project contains a set of test projects to improve the quality of inspectIT. Please note that our unit tests are - as usual - contained with the code base of core inspectIT.

# Manual regression test 
This project contains a set of tests that we use to manual perform regression tests on inspectIT. These test cases are meant to be run with an inspectIT agent attached to test the whole chain from agent to server to ui.

This project is structured as a set of testng testcases that perform a set of operations for the different sensors we have in inspectIT. We chose testng as this provides a well-defined structure and reporting for the tests.

Bear in mind that this is not an automated regression test in which the test cases themself report back in case of an error, but we use the testcases to structure the tests themselves. If a test succeeds this does not signal that the functionality is working (e.g. the UI does not display the information correctly, the server drops the data, ...)

## Run the test
The tests are meant to be run within the IDE of your choice by executing the LaunchTest.launch file (preferred) or by executing the testng suite at resources/testng/testng.xml (Running the test without the launch configuration will not integrate the java agent).

1) Ensure that you [setup the development environment!] (https://inspectit-performance.atlassian.net/wiki/display/DEV/Development+Environment). Especially ivy and testng are required.
2) Checkout the inspectIT core project
3) Run the inspectIT Server (CMR)
4) Run the test by executing the file "LaunchTest.launch" (in Eclipse you can easily right-click -> Run-As -> Launch Test
5) Check the output within your IDE or navigate to test-output/index.html

## Extending the test suite
If you realized a new (or enhanced and existing) feature please add additional tests. 



