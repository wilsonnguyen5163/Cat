
def updating_cat_value (id, cat_file):
    """
    Take in cat's id (id) and cats information file (cat_file)
    If id is in the cats information file then prompt the user to choose what info to be updated
    :param id: int
    :param cat_file: File
    :return: None
    """
    special_char = '"[]'
    try:
        check = True
        lines = cat_file.readlines()  # storing all lines into a list of cats
        ids = []
        for temp in lines:
            ids.append(int(temp.split(":")[0]))
        while check:
            count = 0
            for line in lines:
                if id == ids[count]:  # getting the index of the cat's file needed to be updated
                    cat_data = line
                    index = lines.index(line)
                    check = False
                count +=1
            if check:
                id = int (input ("Invalid ID, please input ID: "))
        cat_data = cat_data.strip().split(":")    # split the right cat's line and split it into List[id, data]
        del cat_data[-1]
        cat_character = cat_data [1:]
        cat_characteristic = []
        for char in cat_character:
            char = char.split (",")
            cat_characteristic.append (char)
        print(cat_characteristic)
        while True:       # while loop to let the user keep editing until they want to stop
            user_input = int(input("What information index (1-22) do you want to change? (Type '-1' to stop): "))
            if user_input == -1:
                break
            print (cat_characteristic[user_input-1])
            updated_info = input ("What would you like to change? (Add, remove, edit): ")
            if updated_info.lower() == "add":      # if user wants to add more information
                info = input ("What would you like to add?: ")
                cat_characteristic[user_input-1].append(info)
                print(cat_characteristic[user_input - 1])
            elif updated_info.lower() == "remove":   # if user wants to remove information
                info = input ("What would you like to remove?: ")
                cat_characteristic[user_input-1].remove (info)
                print (cat_characteristic[user_input-1])
            elif updated_info == "edit":   # if user wants to edit existing information
                print (cat_characteristic[user_input-1])
                info = input ("What would you like to edit?: ")
                index_to_be_changed = cat_characteristic[user_input-1].index (info)
                old_info = info
                new_info = input ("Please enter the new information: ") # get new info to replace the old info
                cat_characteristic[user_input - 1][index_to_be_changed]= cat_characteristic[user_input-1][index_to_be_changed].replace (old_info, new_info)
                print(cat_characteristic[user_input - 1])
        final = ""
        for c in range (len(cat_characteristic)):
            for b in range(len(cat_characteristic[c])):
                final += cat_characteristic[c][b] + ","
            final = final [:-1]
            final += ":"

        cat = str (id) + " :" + final
        lines[index] = cat  # finalize the list of cats
        print (lines)
        file.truncate(0)
        file.seek (0)
        for line in lines:
            file.write(line)  # Saving into file
            file.write ("\n")

    except IndexError:           # get invalid input error
        print ("Invalid input, please try again.")


with open ("cat.txt", "r+") as file:
    id_num = input("Please enter the cat's ID that you wish to modify: ")
    updating_cat_value(int (id_num), file)


from typing import List, TextIO


def add_cat(cat: TextIO) -> None:
   characteristics = ['proposal date (mmddyy)', 'name', 'breed', 'location', \
                      'adoption counsellor', 'microchip', 'age', 'sex', \
                      'spayed/neutered', 'shelter name', 'shelter id', \
                      'to post', 'posted', 'store', 'FIV date (mmddyy)', 'FVRCP date (mmddyy)', \
                      'rabies date', 'medical notes', 'behaviour notes', \
                      'outcome', 'intake date (mmddyy)']

   cat_id = input ("Please enter the cat's ID: ")

   list_characteristic = ""
   for char in characteristics:
       cat_info = input('Please enter the ' + "'" + char + "'" ' of the cat, if there are more than 1 information, '
                                                           'separate them using commas in between: ')
       cat_info = cat_info + ":"
       list_characteristic +=(cat_info)
   cat.write (cat_id + " : " + str(list_characteristic))
   cat.write('\n')


answer = input('Would you like to input information for a cat? Y or N?: ')
while answer == 'Y' or answer == 'y':
   f = open('cat.txt', 'a')
   add_cat(f)
   f.close()
   answer = input('Would you like to input information for another cat? Y or N?: ')

print('End of program')