# Author: Alessandro Bianchi
# Version: 1.0
# Last update: 06/06/2020
#
# Ping google.com every 5 seconds
# Store the date (day + hour) and the result of ping in a file named YYYY-MM-DD

#!/bin/bash

while :
do
	time=$(date)
	day=$(date +"%F")
	result=$(ping -c 1 google.com)

	if [ ! -f "$day" ]; then
		echo "BASH" >> $day
	fi

	echo $time >> $day
	echo $result >> $day
	sleep 5
done
