# Author: Alessandro Bianchi
# Version: 1.0
# Last update: 06/06/2020
#
# Ping google.com every 5 seconds
# Store the date (day + hour) and the result of ping in a file named YYYY-MM-DD

while(1)
{
    $date = $((Get-Date).ToString('yyyy-MM-dd HH:mm:ss'));
    $file = $((Get-Date).ToString('yyyy-MM-dd'));

    if(!(Test-Path $file -PathType Leaf))
    {
        echo "POWERSHELL" >> $file
    }

    $ping = Test-Connection -ComputerName google.com -Count 1;

    $pingResult = $ping.Address + " " + $ping.ProtocolAddressResolved + " " + $ping.ResponseTime;

    echo $date >> $file;
    echo $pingResult >> $file;

    Start-Sleep -Seconds 5;
}