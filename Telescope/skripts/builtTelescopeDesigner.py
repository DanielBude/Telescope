import os

os.chdir("../")

# get repository
print("### get latest version ###")
os.system("git pull")

#start build
print("### start maven build ###")
os.system("mvn clean install")

input("press Enter ...")
