# While a user is downloading a file which is X bytes in size, your job is to provide a function to estimate
# the time remaining in minutes. The system has a record of the amount (in bytes) B downloaded each minute. While
#
# If the file is not completely downloaded, estimate the rate by taking the simple average of the last Z observations.
#
# Write a function:
#   def solution(X, B, Z)
# that returns the amount of time remaining in minutes. X is an integer representing the file size. B is an array
# of integers listing the bytes downloaded at each minute starting from the beginning of the download until now.
# Return an integer representing the number of minutes remaining. Z is an integer.
# You may assume that all the values are reasonable.
#
# Example:
# 1.
#   X = 100, B = [10,6,6,8], Z = 2
#   30 bytes = 10 + 6 + 6 + 8 have been downloaded.
#   So 70 bytes remain.
#   The average of the last two minutes (Z = 2) is 7 = (6 + 8) / 2.
#   So the function should return 10 minutes (=70/7).
#
# Note that:
#   * If there are fewer than Z observations, use what you do have.
#   * Your estimate should be rounded up to the nearest integer (ceiling).
#   * If the download is done, return 0
#   * If you are unable to produce an estimate, return "-1."

import math

def solution(K, B, Z):
    """
    Estimate the download time for a file.
    :param K: the size of the file in bytes
    :param B: a list of bytes downloaded so far
    :param Z: the current time in seconds
    :return: the estimated download time in seconds
    """

    # Calculate the number of bytes downloaded so far
    bytes_downloaded = sum(B)

    bytes_remaining = K - bytes_downloaded
    # calculate average speed in Z
    if len(B) < Z:
        return -1;

    if bytes_remaining == 0:
        return 0;

    average_speed = sum(B[-Z:]) / Z

    return math.ceil(bytes_remaining / average_speed)
