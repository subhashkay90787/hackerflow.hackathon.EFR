import requests
import RPi.GPIO as GPIO
import time
import os, sys
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(35, GPIO.OUT)      //GPIO19
GPIO.setup(12, GPIO.OUT)      //GPIO18
GPIO.setup(36, GPIO.OUT)      //GPIO16
GPIO.setup(33, GPIO.OUT)      //GPIO13
GPIO.setup(32, GPIO.OUT)      //GPIO12
GPIO.setup(38, GPIO.OUT)      //GPIO20
GPIO.setup(40, GPIO.OUT)      //GPIO21


digitclr=[1,1,1,1,1,1,1]
digit0=[0,0,0,0,0,0,1]
digit1=[1,0,0,1,1,1,1]
digit2=[0,0,1,0,0,1,0]
digit3=[0,0,0,0,1,1,0]
digit4=[1,0,0,1,1,0,0]
digit5=[0,1,0,0,1,0,0]
digit6=[0,1,0,0,0,0,0,]
digit7=[0,0,0,1,1,1,1]
digit8=[0,0,0,0,0,0,0]
digit9=[0,0,0,1,1,0,0,]
gpin=[35,12,36,33,32,38,40]
gpin1=[13,15,19,18,16,11,7]
gpin2=[23,24,31,29,26,22,21]
def digdisp(digit):
    for x in range (0,7):
        GPIO.output(gpin[x], digitclr[x])
    for x in range (0,7):
        GPIO.output(gpin[x], digit[x])
def digdisp1(digit):
    for x in range (0,7):
        GPIO.output(gpin1[x], digitclr[x])
    for x in range (0,7):
        GPIO.output(gpin1[x], digit[x])
def digdisp2(digit):
    for x in range (0,7):
        GPIO.output(gpin2[x], digitclr[x])
    for x in range (0,7):
        GPIO.output(gpin2[x], digit[x])
while 1:
    i =1
    url = "https://api.thingspeak.com/channels/390894/feeds.json?api_key=DTUR3W1PJUFCZITU&results="+str(i)

    response = requests.get(url)

    if response.status_code == 200:
        print ('Success!')
    else:
        print ('Check Internet connection.')

    data = response.json()


   

    feild = []
    for i in range(1, 6):
        value = data['feeds'][-1]['field'+str(i)]
        if value == None:
            feild.append(-1)
        else:
            feild.append(int(value))

    count=0
    value=0
    for i in range(0,5):
        if feild[i] != -1:
            count=i+1
            value=feild[i]
        
   

    lon=int(value/100)
    lat=value%100
    a=int(lat/10)
    b=lat%10
    count=str(count)
    digit="digit"
    digit=digit+count

    digdisp(digit)
    digdisp1(a)
    digdisp2(b)
    time.sleep(3)
    a=int(lon/10)
    b=lon%10
    digdisp1(a)
    digdisp2(b)
