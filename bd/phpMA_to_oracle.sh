#! /bin/bash

scphpMA=$1

cat $scphpMA | sed -e"s/VARCHAR/VARCHAR2/g" -e"s/INTEGER/NUMBER/g" -e"s/DECIMAL/NUMBER/g"  >scoracle.sql
