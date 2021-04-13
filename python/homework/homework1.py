# 1.
def is_older(date1, date2):
    if date1[0] == date2[0] and date1[1] == date2[1] and date1[2] == date2[2]:
        return False
    elif date1[0] > date2[0]:
        return False
    elif date1[0] == date2[0]:
        return is_older((date1[1], date1[2], 0), (date2[1], date2[2], 0))
    else:
        return True


# print(is_older((3, 4, 4, 3), (4, 5, 4)))


# 2.
def number_in_month(dates, month):
    if not dates:
        return 0

    h, *t = dates
    if h[1] == month:
        return 1 + number_in_month(t, month)
    else:
        return number_in_month(t, month)


# print(number_in_month([(2000, 4, 4), (2000, 5, 4), (2000, 5, 10), (2000, 5, 8)], 5))

# 3.
def number_in_months(dates, months):
    if not months:
        return 0
    else:
        h, *t = months
        return number_in_month(dates, h) + number_in_months(dates, t)


# print(number_in_months([(2000, 2, 1), (2000, 2, 1), (2000, 3, 1), (2000, 2, 1)], [1, 2]))

# 4.
def dates_in_month(dates, month):
    if not dates:
        return []

    h, *t = dates
    if h[1] == month:
        return [h] + dates_in_month(t, month)
    else:
        return dates_in_month(t, month)


# print(dates_in_month([(2000, 2, 1), (2000, 2, 2), (2000, 3, 1), (2000, 2, 3)], 2))

# 5.
def dates_in_months(dates, months):
    if not months:
        return []

    h, *t = months
    return dates_in_month(dates, h) + dates_in_months(dates, t)


# print(dates_in_months([(2000, 2, 1), (2000, 2, 2), (2000, 3, 1), (2000, 2, 3)], [2, 3]))
# print(dates_in_months([(2000, 2, 1), (2000, 2, 2), (2000, 3, 1), (2000, 2, 3)], [2, 4]))
# print(dates_in_months([(2000, 2, 1), (2000, 2, 2), (2000, 3, 1), (2000, 2, 3)], [3, 4]))
# print(dates_in_months([(2000, 2, 1), (2000, 2, 2), (2000, 3, 1), (2000, 2, 3)], [1, 4]))


# 6.
def get_nth(strings, n):
    if not strings or n == 0 or n > len(strings):
        return "Error"

    h, *t = strings
    return h if n == 1 else get_nth(t, n - 1)


# 6.1
def get_nth_simplified(strings, n):
    if not strings or n == 0 or n > len(strings):
        return "Error"
    return strings[n - 1]


# print(get_nth(["a", "b", "c", "d"], 0))
# print(get_nth(["a", "b", "c", "d"], 1))
# print(get_nth(["a", "b", "c", "d"], 3))
# print(get_nth(["a", "b", "c", "d"], 4))
# print(get_nth(["a", "b", "c", "d"], 5))
# print(get_nth([], 4))


# 7.
def date_to_string(date):
    months_names = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                    "November", "December"]
    return get_nth(months_names, date[1]) + " " + str(date[2]) + ", " + str(date[0])


# 7.1
def date_to_string_simplified(date):
    months_names = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                    "November", "December"]
    return "{} {}, {}".format(get_nth(months_names, date[1]), date[2], date[0])


# print(date_to_string((2000, 1, 2)))


# 8
def number_before_reaching_sum(defined_sum, numbers):

    def extended_nested(sum_nested, numbers_nested, n):
        h, *t = numbers_nested
        new_sum = sum_nested - h
        if new_sum <= 0:
            return n
        else:
            return extended_nested(new_sum, t, n + 1)

    return extended_nested(defined_sum, numbers, 0)


# print(number_before_reaching_sum(50, [20, 20, 20]))
# print(number_before_reaching_sum(50, [50, 20, 20]))
# print(number_before_reaching_sum(50, [20, 30, 20]))

# 9
def what_month(day):
    months_length = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    return number_before_reaching_sum(day, months_length) + 1


# print(what_month(12))
# print(what_month(40))
# print(what_month(31))
# print(what_month(32))
# print(what_month(59))
# print(what_month(60))
# print(what_month(90))
# print(what_month(91))
# print(what_month(365))


# 10
def month_range(day1, day2):
    return [] if day1 > day2 else [what_month(day1)] + month_range(day1 + 1, day2)


# print(month_range(3, 3))
# print(month_range(31, 32))
# print(month_range(31, 33))
# print(month_range(29, 33))


# 11.
def oldest(dates):
    if not dates:
        return None

    h, *t = dates
    tmp_answer = oldest(t)
    return tmp_answer if tmp_answer is not None and is_older(tmp_answer, h) else h


# print(oldest([(2000,1,1),(2000,2,1),(1998,1,2),(2000,3,1),(1999,3,2)]))
# print(oldest([(2000,1,1),(2000,2,1),(2001,1,2),(2000,3,1),(1999,3,2)]))
# print(oldest([(2000,1,1),(2000,2,1),(2000,1,2),(2000,3,1),(2000,3,2)]))
