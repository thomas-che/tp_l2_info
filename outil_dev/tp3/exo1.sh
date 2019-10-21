#!/bin/bash

nbligne=$(cat /usr/share/dict/words | wc -l)
ligne=$(($RANDOM%nbligne))
tail -n $ligne /usr/share/dict/words | head -n 1
