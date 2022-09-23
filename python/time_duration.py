# From an integer X representing a time duration in seconds produce a simplified string representation
# For example, given X = 100, you should output: "1m40s"
#
# Use the following abbreviations w,d,h,m,s to represent:
# 1w is 1 week
# 1d is 1 day
# 1h is 1 hour
# 1m is 1 minute
# 1s is 1 second
#
# Only the two largest non-zero units should be used. Round up the second unit if necessary so that the output
# only has two units even though this might mean the output is for slightly more time than X seconds.
#
# Write a function: def solution(X)
# that, given an integer X, returns a string representing the duration.
#
# Examples:
# 1. Given X-100, return "1m40s"
# 2. Given X=7263, return "2h2m". (7263s-2h1m3s, but this uses too many units, so we round the second largest unit up to 2h2m)
# 3. Given X-5, return "5s"

def solution(X):
    time = X
    week,day,hour,min,sec = 0,0,0,0,0

    # 1 week has 604800 secs so taking dividing it with 604800 gives number of weeks
    week = time // 604800

    # remove weeks time from input time
    time = time % 604800
    day = time // 86400
    time = time % 86400
    hour = time // 3600
    time = time % 3600
    min = time // 60
    time = time % 60
    sec = time

    #ans to store output string
    ans = ""
    #count to store count of how many pnputs has been added to ans string
    count = 0

    #if week has some value other than 0 then increment count first and check if count value is less than 2
    #if yes add week in ans
    if week != 0:
        count = count + 1
        if count < 2:
            ans = ans + str(week) + 'w'

    #if day has some value other than 0 then increment count first and check if count value is less than 2
    #if yes add week in ans
    #else if count is 2 and hour is yet to be added then increment day and add to ans variable
    if day != 0 :
        count = count + 1
        if count < 2:
            ans = ans + str(day) + 'd'
        elif count == 2 and hour != 0:
            ans = ans + str(day+1) + 'd'

    if hour != 0 :
        count = count + 1
        if count < 2:
            ans = ans + str(hour) + 'h'
        elif count == 2 and min != 0:
            ans = ans + str(hour+1) + 'h'

    if min != 0 :
        count = count + 1
        if count < 2:
            ans = ans + str(min) + 'm'
        elif count == 2 and sec != 0:
            ans = ans + str(min+1) + 'm'

    if sec != 0:
        count = count + 1
        if count <= 2:
            ans = ans + str(sec) + 's'

    return ans
