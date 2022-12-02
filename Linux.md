# <u>LINUX COMMAND LINE</u>

---

[Markdown](https://github.com/marktext/marktext/blob/master/docs/MARKDOWN_SYNTAX.md#bar)

##### 1 - <u>List Storage</u>

`ls`

options - 

| OPTIONS | FUNCTION            |
|:-------:| ------------------- |
| l       | list in line format |
| a       | hidden files        |

 For example - 

```bash
Print the directory root in line format
ls -l / 
```

`/` is shorthand for **root** directory

`~` is shorthand for **home** directory

> ###### If you print a directory, the files, folders or binaries might be colored, but if they aren't, just look at the first character of *permissions*, if the character is -
> 
> ##### d     -> Directory
> 
> ##### -      -> File
> 
> ##### l      -> Link to another file(Shortcuts)

---

##### 2 - <u>Print Working Directory</u>

`pwd`

Prints current directory

---

##### 3 - <u>Change Directory</u>

`cd`

| Directory    | What they are?                                   |
|:------------:|:------------------------------------------------:|
| **.**        | current directory                                |
| **..**       | Previous or Parent Directory                     |
| string(name) | The name of the directory to which we want to go |

```bash
For Current Directory -
cd .
For Previous directory -
cd ..
For directory named 'Downloads' - 
cd Downloads
```

---

###### <u>File Editing</u>

##### 4 - <u>Update Properties</u>

`touch`

Updates a file's properties by touching or changing values

```bash
touch Filename.txt
```

The above command -

1. If the **Filename.txt exists**, the touch command update the properties(modifies time).

2. If the **Filename.txt doesn't exists**, the touch command creates the file.

##### 5 - <u>Concatenation</u>

`cat`

```bash
cat Filename.txt
```

There are two types -

1. If there is just **one file named** in the command -

       The above command shows the contents of the file 

2. If it has two or more files -
   
   ```bash
   cat File1.txt File2.txt
   ```

        The cat command appends the content of file2.txt into File1.txt and prints the output

##### 6 - <u>Text Editing</u>

`nano`

This command opens an editor where text can be edited, which can be **saved by using**

**'Write Out'(^O) -> 'Exit'(^X)**, where ^ is ctrl key-

```bash
nano
```

If the file exists, This command opens the file in the editor. If the file doesn't exists, This command creates the file and opens in the editor. -

```bash
nano File.txt
```

---

##### 7 - <u>Which folders contains the command</u>

`which`

```bash
which command
```

command could be anything like `ls`,  `nano`, `vim` etc. Returns mostly the directory where the binary is placed.

---

###### <u>Moving and Renaming Files</u>

##### 8 - <u>Copying Files</u>

```bash
cp f1.txt f2.txt
```

This command copies the content of *f1.txt* to *f2.txt*. The contents of *f2.txt* is removed and then the content of *f1.txt* is copied in it. 

| FLAGS           | WHAT THEY DO?                                                                    |
|:---------------:|:--------------------------------------------------------------------------------:|
| -v              | Tell what is happening('f1.txt' -> 'f2.txt', the contents of f1 is pasted in f2) |
| --preserve=MODE | Doesn't changes the Properties specified in MODE(=mode,ownership,timestamps)     |
| -r              | Recursively copy all the contents of a directory into another directory          |

```bash
cp -r Test/ Test2/
```

        results in copying whole directory Test/ into Test2/, and would look like this ->

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-08-31-10-12-59-image.png)

##### 9 - <u>Finding the difference</u>

`diff`

The command finds the difference between the files or directories

```bash
diff f1.txt f2.txt
```

    find the difference between the contents of file f1 and f2 and shows it.

```bash
diff Test/ Test2/
```

    shows the difference of files inside the directories

##### 10 - <u>Moving Files</u>

`mv`

Moves the files into said path

```bash
mv f1.txt Test2/
```

        moves the file f1 to Test2/

```bash
mv *.txt Test2/
```

        Moves all the Text Files into Test2/

```bash
mv *.txt ..
```

        Moves all the files into the Parent Directory

##### 11 - <u>Removing Files</u>

`rm`

Permanently deletes the files or directories

```bash
rm f1.txt
```

| FLAGS | WHAT THEY DO?                                                                |
|:-----:|:----------------------------------------------------------------------------:|
| -r    | Recursively delete all the directories and the files and folders inside them |
| -d    | removes the directory, Required when removing folders.                       |
| -v    | Tell what's happening when running the command                               |
| -i    | Prompt for deletion                                                          |

##### 12 - <u>Renaming Files</u>

`mv`   -- Uses the move command

```bash
mv f1.txt newfile.txt
```

        Moves the contents and hence rename it to newfile.

---

###### <u>Bash Configuration</u>

The bash configuration file(.bashrc) is a configurable file that is in HOME directory of every user(default for all is inside `/etc/skel/`).

This file can be configured to execute modified commands inside shell(Terminal).

##### 13 - <u>Alias</u>

`alias`

Alias is another name for something(in this case, Commands). We can setup aliases and execute the same commands through shorter names.

        *Open the **.bashrc** file inside the the **HOME** Directory by using **`nano .bashrc`**. Set up aliases for the below commands.*

```bash
alias c = 'clear'     #A
alias hc = 'history -c'  #B 
```

        The above command sets ->

                1. **`c`** can now be used instead of **`clear`**

                2. **`hc`** can now be used to clear history instead of **`history -c`**

- To print all the **Alias**, type `alias` and then hit <kbd>Enter</kbd>.

- To print an alias for something, type `alias name`, where name is any alias we set for a command.

- To **remove** an alias, type `unalias name` where name is any alias we set for a command (The command's alias is removed only for the current terminal if the command is aliased inside the <u>*.bashrc*</u> file, just restart the terminal and the alias will be back, to remove permanently, remove it using nano from .bashrc file).
* Try out `alias weather='curl wttr.in'` to show weather for your place.

---

###### <u>Permissions</u>

The permission are the properties of Editability of a file or folder, it tells who can edit or read or remove any file or folder.

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-01-11-05-47-image.png)

    The first permission line is -- `drwxr-xr-x` for desktop.

The permission is divided into *four* parts.

```
d | rwx | r-x | r-x
```

1. The first tells what is the type of the entry. ( `d` for directory, **-** for file)

2. The second line tells what permissions are given to the **Use**(in this case **v** is the user and owner of the file which has the permission `rwx`).

3. The third is the permissions of the Group(**v** in this case is the group which have the user **v**, they could be different, but they have the permissions o`r-x`)

4. The fourth is for any other person other than the members of the group(The world, which has the permission of `r-x`)

| Permission | What permission is given? |
|:----------:|:-------------------------:|
| `r`        | Read                      |
| `w`        | Write                     |
| `x`        | Execute                   |
| `-`        | Permission not given      |

**Always remember the permissions are <u>positional values</u>, so in the case `rw-`, the user has the the permissions of `r` and `w` but doesn't have the permission of `x` which in this case is represented as `-`, you could remember it as the absence it the permission.**

<u>**Changing Permissions**</u>

- Create a script

```bash
nano myscript.sh
```

- Enter the command `ls -l` as text, so when we run the script, the command is executed.

- Then, try to run the command using `./myscript.sh`, and it says permission denied.

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-01-11-30-33-image.png)

- Then `ll` the folder, you will see the permission to execute is not given to the user(or group or world).

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-01-11-32-04-image.png)

- We need to change permission to make it executable ->

```bash
chmod +x myscript.sh
```

   `chmod` is **the command and system call used to *change the access permissions* and the special mode flags (the setuid, setgid, and sticky flags) of file system objects (files and directories)**

`+` is for adding a permission.

`-` is for removing a permission.

-   But the above command change the permission to executable for everyone(user,group and others).
  
  ![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-01-11-43-46-image.png)

- To remove the permissions - 

```bash
chmod -x myscript.sh
```

- Give new permissions to the user only -

```bash
chmod u+x myscript.sh
```

    The `u+x` gives the permission to execute the script only to the user, and not anyone else.

- Add all permissions to everyone -
  
  ```bash
  chmod a+rwx myscript.sh
  ```

- We can also change permissions numerically(pretty bad idea btw)
  
  ```bash
  chmod 755 myscript.sh 
  ```

        The numbers are assigned to User, Group and Others respectively. The numbers are the sum of the following -

        **4** - Read permission, **2** - Write permission, **1** - Execute, **0** - No permission

        So the user has `rwx`, the group and others have `r-x`.

The permissions discussed above are for files, the permissions for directory is different from file permission, although permission letter are same.

For a directory - 

| Permission | What it is?                             |
|:----------:|:---------------------------------------:|
| `r`        | Read the contents of directory          |
| `w`        | Able to change contents of directory    |
| `x`        | Able to enter inside over the directory |

---

###### <u>Packages</u>

Packages are the software that are stored on any repository.

***Remember, different distribution of linux has a different package managers.***

For debian based distros like Ubuntu, the package manager is `apt`, also try `nala` for debian-based distros.

So anything below is specific to Ubuntu and similar systems only.

| APT commands   | Functions                                                       |
|:--------------:|:---------------------------------------------------------------:|
| `list`         | list packages on packages name                                  |
| `search`       | search in package descriptions                                  |
| `show`         | show package details                                            |
| `install`      | install packages                                                |
| `reinstall`    | uninstall packages                                              |
| `remove`       | remove packages                                                 |
| `autoremove`   | automatically remove all unused packages                        |
| `update`       | update list of available packages                               |
| `upgrade`      | upgrade the system by installing/uninstalling packages          |
| `full-upgrade` | upgrade the system by removing/installing/uninstalling packages |
| `edit-sources` | edit the source file info                                       |
| `satisfy`      | satisfy dependency strings                                      |

<u>Update Repository list</u>

```bash
sudo apt update
```

    This command will update all the repositories of softwares inside our system and their dependencies.(It didn't updated the software itself!)

    ![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-02-05-15-14-image.png)

    See _14 packages can be upgraded._

<u>List of upgradable packages</u>

```bash
apt list --upgradable
```

    *Not including `sudo` as we aren't making any changes to the system.*

<u>Search for a package</u>

```bash
apt search firefox
```

    *Will search the string 'firefox' inside repositories and descriptions.*

<u>Install a Package</u>

```bash
sudo apt install apache2
```

    *Will install apache2 software.*

<u>Removing all the now unwanted dependencies</u>

```bash
sudo apt autoremove
```

<u>Upgrade packages</u>

```bash
sudo apt upgrade
```

---

###### <u>Managing Systemd Units</u>

Systemd is a suite of basic building blocks for a Linux system. It provides a system and service manager that runs as PID 1 and starts the rest of the system.

For beginners, `systemctl` which is a part of linux works well enough.

| Commands  | Function                   |
|:---------:|:--------------------------:|
| `start`   | start a service            |
| `stop`    | stop a service             |
| `reload`  | Reload one or more units   |
| `restart` | Restart one or more units  |
| `status`  | get the status for an unit |
| `enable`  | Enable a unit              |

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-02-14-09-44-image.png)

```bash
systemctl stop apache2 #stops the service apache2
```

---

###### <u>Logs</u>

Linux provides a lot of different types of logs by default. These files are generally located at **/var/log** . There may be some exceptions like third party applications but the configuration of log location can be changed to the **/var/log** directory.

```bash
cat /var/log/syslog
```

will print the  **system logs**.

```bash
ls /var/log #contains all the important logs for linux system
```

    Output -

![](C:\Users\kharw\AppData\Roaming\marktext\images\5823fe8a9b8208e909990ebc2319cb3640d1bc16.png)

<u>**Head and Tail Printing**</u>

`head` prints the first 10 lines(default)

```bash
head /var/log/syslog
```

`tail` prints the last 10 lines

```bash
tail /var/log/syslog
```

    Add a flag `-5` , where 5 is the number of lines you want to print.

also..

```bash
tail -f /var/log/syslog
```

The above commands follows any system changes, so if any service is started/stopped/restarted etc., it shows the updates(Remember, tail only watches file and is independent of what is shown, only for syslog the logs will be printed, for any other file, only if the file is changed it shows the changes).

<u>**Journalctl**</u>

It's a part of systemd, which shows the logs, but also can show logs only for one unit.

```bash
journalctl -u ssh
```

    shows all the logs for ssh.

---

###### <u>Managing Users</u>

Users are the people who use the computer(same OS) or sometimes the Daemons that runs the process inside the OSs.

Every user is given a user id(UID), the human users *generally* have a >1000 UID.

```bash
cat -n /etc/passwd
```

    **/etc/passwd** file shows you a list of users and detailed information about them.

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-03-12-32-28-image.png)

`root:x:0:0:root:/root:/bin/bash`

Each line contains seven type of information.

- Username
- User's password - the password is not really stored in this file, 
  it's usually stored in the /etc/shadow file. If you see an "x" that means the password is stored in the 
  /etc/shadow file, a "*" means the user doesn't have login access and if 
  there is a blank field that means the user doesn't have a password.
- The user ID - as you can see root has the UID of 0
- The group ID
- GECOS field - This is used to generally leave comments about the 
  user or account such as their real name or phone number, it is comma 
  delimited.
- User's home directory
- User's shell - you'll probably see a lot of user's defaulting to bash for their shell

```bash
cat -n /etc/shadow
```

    **etc/shadow** contains the passwords for all the users in Encrypted Format

```bash
cat -n /etc/group
```

    **etc/group** shows all the groups present on the system

Alternatively, use

```bash
groups
```

or 

```bash
groups viny # to find what group viny belongs to
```

<u>**Add User**</u>

```bash
sudo adduser name
```

- To login the user, use `su - name`, to logout, enter `logout`, If you use `sudo su - name` then you won't be asked for password to access as **root** can do anything in the system.

- To **change password** for the user currently logged in, use `passwd` , through sudo(root), you can change anyone's password.

**<u>Remove User</u>**

```bash
sudo userdel -r name
```

`-r` to remove the *HOME directory.*

To check, type `ls -l /home`.

**<u>Add Group</u>**

```bash
sudo groupadd GroupName
```

**<u>Add user to a group</u>**

```bash
sudo usermod -aG groupName userName
```

    Have to logout-login to see effect, or check through `groups userName`.

**<u>Remove user from a group</u>**

```bash
sudo gpasswd -d userName groupName
```

**<u>Delete a group</u>**

```bash
sudo groupdel groupName
```

---

###### **<u>History</u>**

`history`

To check history.

```bash
history
```

To clear history --

```bash
history -c 
```

To not include the command in history, type a ` ` (space) before typing the command.

---

###### <u>Output Redirection</u>

The output for any command can be written inside a file.

**But remember, this `>` symbol will overwrite the contents inside the file.****

```bash
ls -la > file.txt
```

    `>` is redirect symbol.

To overcome this, use `>>` to preserve the contents of the file.

**Appending to a file**

```bash
ls -l >> file.txt
```

**<u>Piping or Transferring an output to another command(|)</u>**

It is used to apply multiple commands on the same output.

```bash
cat file.txt | sort | uniq
```

    The above command will generate an output of file.txt, that output will be transferred to the `sort` command which is used to sort the output, next that it      transferred to the `uniq` command, which finds the unique command, then the generated output after all the three commands will be printed.

    `sort` --- will sort

    `uniq` --- finds unique lines

The below command prints out the results of lines that contains a string(or regular expression).

```bash
cat file.txt | grep string
```

    `grep`is a command-line utility for searching plain-text data sets for lines that match a regular expression

The below command counts the number of lines in any file

```bash
cat file.txt | wc -l
```

    `wc` is short for word count, the `-l` flag counts the number of lines, `-w` command counts the number of words, `-m` counts the number of characters.

---

###### **<u>Input/Output Streams(i/o streams)</u>**

**Standard Output-**

Or stdout, is the output stream that refers to any output(display or file) that the user got.

Commands like `ls`, `cat`, `wc` etc. all are stdout commands as they give output to the user.

**Standard Error-**

Or stderr, Similar to stdout, but the output is <u>Error</u>

How to only print the stdout and not stderr? -

```bash
find / *.txt 2> /dev/null 
```

which transfers all the errors inside the /dev/null which is a file that is used to dump results(garbage).

See the `2>` which redirects the error, if it was `1>` it would only transfer the output(output with no error).

> To check if the previous output was an stdout or stderr, type `echo $?` , if the output is **0*** the previous output is successful and is**stdout**, if it's **2**, the output was error and is **stderr**.

**Standard Input-**

We have different stdout streams we can use, such as a file or the screen. Well there are also different standard input (stdin) streams we can use as well. We know that we have stdin from devices like the keyboard, but we can use files, output from other processes and the terminal as well.

```bash
cat < helllo.txt
```

    In the above example, the standard input is a file.

To redirect both stdout and stderr in a file.

```bash
ls /fake/directory &> peanuts.txt
```

---

**`tr` (Translate)**

The tr (translate) command allows you to translate a set of characters into another set of characters. Let's try an example of translating all lower case characters to uppercase characters. 

```bash
tr a-z A-Z
```

    A prompt will ask you to enter the words you want to translate, when hit <kbd>enter</kbd>, will UPPERCASE the input.

**`nl` (Number the lines)**

The output lines will have numbers

```bash
nl helllo.txt
```

 ---

###### **<u>Variables</u>**

Variables are the containers of information.

`variableName = varibleValue`

A variableName is the name of the variable and variableValue is the value of that variable. For String, we use "string".

```bash
HELLO = "HELLO WORLD"
```

To access the variable, use the `$`

```bash
echo $HELLO
```

**Current Environment**

`env`

```bash
env
```

Prints the session environment variable.

**Exporting the variable to ENV**

```bash
export downloads="/~/v/Downloads"
```

---

###### <u>Find</u>

`find`

Finding files and directories.

```bash
find /var -type f -name "*log*" 2> /dev/null
```

    The above command finds -

- In the **var** directory  

- A file using `-type f`, for directory `-type d`

- The name containing `log`, in between names.

- Error is outputted to sink

```bash
find /var/log -type f -name "*.log" -mtime 7 -exec rm {} \;
```

    The above command does -

* find any file ending with .log, modified within 7 days, and removes it using rm command.

 
