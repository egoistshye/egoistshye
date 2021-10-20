mport matplotlib.pyplot as plt
import time

# read the list of books from an imported text file and then display in a structured list data type

books = open("booktitles.txt", "r").read()  # this opens the txt file in a read only format
newbooks = open("new_book_list.txt", "r").read() # used for function 4

book_data = []
for line in books.split("\n")[2:]:
    stripped_line = line.strip()
    line_list = stripped_line.split()
    book_data.append(line.split(", "))

def main():
    infile = open('booktitles.txt', 'r')

# this code displays output
def number1():
    for book in book_data:
        print(". ".join(book))
    print("")
    each = 0 # this allows for every record to be displayed as every time the for loop repeats itself it adds one
    print("Summary of titles in stock:")
    for book in book_data:
        book_name = book_data[each][1] # book name is 1 in the index
        book_stock = book_data[each][5] # book stock is 5 in the index
        book_cost = book_data[each][4] # book cost is 4 in the index
        total_bookvalue = float(book_cost) * float(book_stock) # book cost multiplied by the number of stock gives total book value
        print(str(book_name) + " | Total Stock: "+ str(book_stock) + " | Total Value: £{:.2f} ".format(total_bookvalue)) # prints out this summary,
        # the .format function forces the number to be to 2 sig fig
        each += 1
    print ("The total number of books in stock is:", len(book_data)) # this counts the number of books in the list, which is 11.
    print("")
    total = 0
    for eachline in book_data:
        total += float(eachline[4]) * float(eachline[5])
    print("The total cost of books in stock is: £", total)

#this code displays the average price of the books in stock for the user
def number2():
    averagecost = 0
    totalcost = 0
    totalstock = 0
    for eachline in book_data:
        totalstock += float(eachline[5]) # totalstock is equivalent to adding every value in index 5
    for eachline in book_data:
        totalcost += float(eachline[4]) * float(eachline[5]) # looks for total cost
    averagecost = (totalstock) / (totalcost) * len(book_data)
    print("")
    return averagecost

#this choice allows the user to view a list of how many books are in a specific genre
def number3():
    genre = [] # we've established that genre is a new separate list referencing off the book list data
    fictionCount = 0
    biographyCount = 0
    religionCount = 0
    scienceCount = 0
    for eachline in book_data:
        genre_Type = str(eachline[6]) # finds genre from the main data list given
        genre.append(genre_Type) # adds a new genre to the genre list
    genredictionary = {"GENRE": "TOTAL", "----": "----"}
    genredictionary.update({i: genre.count(i) for i in genre}) # this line adds each genre type to a dictionary before counting the
    # occurence of each type
    print("\n".join("{:10} {:5}".format(k, v) for k, v in genredictionary.items()))
    #outputs a report of the amount of books in each genre and formats it to be more user friendly for end user

# this code allows the user to input a new set of data that can be written to a text file
def number4():
    book_author = input("Please enter the author name: ")
    book_title = input("Please enter the book's title: ")
    book_format = input("Please enter the book format: ")
    book_format = book_format.lower()
    book_publisher = input("Please enter the book publisher: ")
    book_cost = float(input("Please enter the book cost: "))
    book_cost = "{:.2f}".format(book_cost)
    book_stock = int(input("Please enter the amount of stock: "))
    book_genre = input("Please enter the book genre: ")

    current_average = number2()

    new_book_list = [book_author, book_title, book_format, book_publisher, book_cost, book_stock, book_genre]
    new_record = open("new_book_list.txt", "a")
    for each in new_book_list:
        new_record.write(str(each) + ",")

    new_record.write("\n")
    new_record.close()
    book_data.append(new_book_list)

    new_average = number2()

    cost_diff = new_average - current_average

    stock_increase = book_stock

    print("The cost difference between average price in book stock is : £{:.2f} ".format(cost_diff))
    print("The stock was increased by: ", book_stock)

#this code is an if statement specific to asking the end-user
# if they would like to increase or decrease the stock level
# any other input is rejected and the code should reject the
# end user's input if the book is not within the book list!
def number5():
    bookquery = input("What book are you looking for?: ")
    for data_row in book_data:
        each = 0 # counts each record in the list. needed for later code
        found_book = False # the input was not found in the list
        bookstock_level = int(book_data[each][5])  # finds the stock level for a specified book

        if bookquery.lower() == data_row[1].lower(): # if the book the user has searched is found in index 1 it'll
            # print a confirmation!
            found_book = True # the book has been found!
            print("\nYour book has been found!")
            if bookstock_level <= 0:  # this checks if the book is NOT in stock
                bookstock_level = input("This book is out of stock. Would you like to increase the stock, Y/N?: ")
                # a yes or no question for the end user to answer
            else:
                print("The current stock level is", bookstock_level)  # this will output the current stock level
                bookstock_selection = input("\nWould you like to change the stock level? Y/N - ")  # Y/N for changing stock

            if bookstock_selection.lower() == "y": # if end user types in yes
                option = input("Would you like to increase(I) or decrease(D) the stock of this book?: ")
                # this gives the user an option to increase or decrease the stock level by entering 1 or 2
                if option == "I":
                    increase = int(input("How much would you like to increase the stock by?"))
                    bookstock_level += increase # this takes index 5 (stock) in the book list and increases it
                    # by the user's specified increase
                    print("\nThe stock level is now: ", bookstock_level)
                elif option == "D":
                    decrease = int(input("By how much would you like to decrease the stock?: "))
                    bookstock_level -= decrease
                    print("The stock level is now: ", bookstock_level)
                    break

        elif bookquery not in book_data[1]:
            each+= 1 # counts the next record if not found in first row of the list, book_data!

    if found_book == False: # the program has recognised the book title doesn't exist so informs the end user!
        print("\nYour input is incorrect, please try again!")

def number6():
    genres = [[str(row[6]), str(row[1])] for row in book_data] #  genre list that stores genres from book_data,
    # index 6. done for code efficiency instead of code redundancy with a future for loop! same for line below.
    book_titles_list = [str(row[1]) for row in book_data] # book list storing titles from book_data, index 1

    user_input = input("\nWould you like to view books ordered by genres(G) or book titles?(T):")
    # this offers the user a choice between genres and titles!

    print("\n") # a new line specific for formatting purposes
    if user_input.lower() == "g": # should the user choose genre the following will occur:
        sorted_by_genre = sorted(book_data, key=lambda  row: row[6]) # sorted works to use our new copy of book_data,
        # returning it in alphabetical order based on row six using lambda !

        for book in sorted_by_genre:
            book_strings = [str(column) for column in book]
            print(". ".join(book_strings)) # prints the book list in alphabetical order via genre

    elif user_input.lower() == "t": # if the user chooses titles the following will occur
        sorted_by_title = sorted(book_data, key=lambda row: row[1])

        for book in sorted_by_title:
            book_strings = [str(column) for column in book]
            print(". ".join(book_strings)) # # prints the book list in alphabetical order via title

def number7():
    genreTitles = [str(eachline[6]).capitalize() for eachline in book_data] # this is a genre titles list
    # specific to the axis labels!

    genredictionary = {i: genreTitles.count(i) for i in genreTitles} # adding genre types to a dictionary before
    # counting how often each type pops up

    plt.bar(*zip(*genredictionary.items()), color="#58D68D") # this plots the bar chart using matplotlib
    plt.title("Number of books in each genre")
    plt.xlabel("Genre")
    plt.ylabel("Books")
    time.sleep(2)
    print("\n------------------------------------     Loading your bar chart!     ------------------------------------")
    plt.show() # output the bar chart using the values above

#Code that sets up a menu
def menuoptions():
    print("""------------------------------------     Select the following task you wish to complete     ------------------------------------
    1. Output a list of book titles including details such as total number of book titles and total value of books in stock.
    2. Output the average price of the books in stock.
    3. Display a report that details the number of books in each genre.
    4. Add a new book and present a summary report that displays total number of sales in stock and the change in \n\taverage book price of stocked books.
    5. Query a book title's availability and choose to increase or decrease stock level.
    6. Create a query in which book items are ordered in alphabetical order by title or genre.
    7. Plot a labelled barchart presenting the number of books in each genre.
    8. Exit.""")
    option = input("\nChoose a task by typing in the associated number.")
    if option == "1":
        number1()
    elif option == "2":
        averagecost = number2()
        print("The average price of books in stock is: £{:.2f}".format(averagecost))
    elif option == "3":
        number3()
    elif option == "4":
        number4()
    elif option == "5":
        number5()
    elif option == "6":
        number6()
    elif option == "7":
        number7()
    elif option == "8":
        exit()

menuoptions()

# REFERENCE LIST
# otmezger (2013). Plot a bar using matplotlib using a dictionary. [online] Stack Overflow.
# Available at: https://stackoverflow.com/questions/16010869/plot-a-bar-using-matplotlib-using-a-dictionary [Accessed 6 Dec. 2020].
# Programiz.com. (2020). Python Lambda (Anonymous) Function. [online] Available at:
#  https://www.programiz.com/python-programming/anonymous-function [Accessed 6 Dec. 2020].
# Programiz.com. (2020). Python sorted(). [online] Available at:
#  https://www.programiz.com/python-programming/methods/built-in/sorted [Accessed 6 Dec. 2020].
# W3schools.com. (2020). Python Dictionaries. [online] Available at:
# https://www.w3schools.com/python/python_dictionaries.asp [Accessed 6 Dec. 2020].
# W3schools.com. (2020). Python Lambda. [online] Available at:
# https://www.w3schools.com/python/python_lambda.asp [Accessed 6 Dec. 2020].
# GeeksforGeeks. (2019). Python exit commands: quit(), exit(), sys.exit() and os._exit() - GeeksforGeeks. [online]
# Available at: https://www.geeksforgeeks.org/python-exit-commands-quit-exit-sys-exit-and-os-_exit/ [Accessed 6 Dec. 2020].