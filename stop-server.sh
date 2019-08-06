#!/bin/bash
ps -ef | grep spring-boot:run | grep -v grep | awk '{print $2}' | xargs kill -9
