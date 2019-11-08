#! /bin/bash

scoracle=$1
											#faux !
cat $scoracle | sed -e"s/VARCHAR2/VARCHAR/g" -e"s/NUMBER/INTEGER/g" -e"s/--/-- /g" -e"s/NUMBER({*},{*})/DECIMAL/g >scphpMA.sql
