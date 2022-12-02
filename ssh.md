# <u>SSH</u>

The Secure Shell Protocol (SSH) is a cryptographic network protocol for operating network services securely over an unsecured network. Its most notable applications are remote login and command-line execution.

Uses Port **22**

Mostly used for remote log-in.

Find if SSH is installed -

```bash
which ssh
```

Find if it's running -

```bash
sudo service ssh status
```

    Try starting it using `sdui systemctl start ssh`

The SSH works under a Client-Server Protocol.

The computer used for accessing another computer's terminal is called the **Client**, and the computer being accessed is called **Server**.

The client must have installed SSH Client for SSH purpose.

Check through -

```bash
apt search openssh-client
```

See if the service is installed, if not then install it using `sudo apt install openssh-client`.

Similarly, the server must have SSH Server installed, check using -

```bash
apt search openssh-server
```

The server must have installed SSH server app to be accessed, else it will produce *Connection Refused*  Error.

Check on the server using `ssh localhost`.

If it says Connection refused, try installing openssh-server.

Check if server is running using - `sudo service ssh status`

If everything goes well, the command to open an SSH terminal on the server through client is -

```bash
ssh user_name@localhost_ip
```

where *user_name* is the user on the server machine which we want to access, and *localhost_ip* is the IP address of that server.

For the first connection establishment, it asks you to install the get the fingerprint generated for connection, the fingerprint is used to identify the server, if it's the one we want to access or not, if their is a MITM attack(Man-in-the-middle), because of the fingerprint, it will identify the server machine as different machine and prompt us to do investigate or accept it.

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-06-15-14-33-ssh-command8.png)

Press <kbd>Ctrl</kbd>+<kbd>d</kbd> to disconnect from the server.

The list of all the known-hosts(the hosts we already have made a connection) is stored inside the **.ssh** directory. Go to **HOME/USER/.ssh**, there we will find **known_hosts** file, `cat`  it open, and you get the hosts, although encrypted.

```bash
cd $HOME/.ssh
```

then, where $HOME is a environment variable containing *Home/user*  path.

```bash
cat known_hosts | nl
```

Catting the hosts and numbering each line.

When a device is connected, it creates logs in /var/log/auth.log

```bash
sudo cat /var/log/auth.log
```

We can see the changes in the file using -

```bash
tail -f auth.log #given we are in /var/log/
```

---

### <u>Configuration storage</u>

But all this is tedious, we can create a config file and automate some stuff-

1. Create a config file inside *~/.ssh
   
   ```bash
   touch config
   ```

2. Nano inside it
   
   ```bash
   nano config
   ```

3. Write this inside the config file, then save it -
   
   ```bash
   Host ubuntu
       Hostname IP_ADDRESS
       Port PORT_NUMBER
       User USERNAME
   ```
   
   Where, Ubuntu is the server name for us, Hostname is the ip address of the server, Port number is the port through which we want to connect to ubuntu, and username is the account which we want to access through.

4. Simply connect using -
   
   ```bash
   ssh ubuntu
   ```

**We can add as many Hosts as we want, all with the basic configuration like in step 3 inside the same config file.**

---

### <u>Using Public and Private Keys</u>

Instead of password, we can also use Public and Private Keys to Login to SSH servers.

First, we need to generate the ssh-keys and then transfer the **Public Key** inside **~/user/.ssh** in the server as **authorised_keys**.

Generating ssh keys -

```bash
ssh-keygen
```

Output-

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-07-20-09-45-image.png)

When we open **~/user/.ssh**, we will find two files, one is the private key, the other will be public key.

**The extension for the public key is .pub, so the public key will be named like *id_rsa.pub***

It might ask us to enter passphrase, that phrase will be required to unlock the ssh-key login and is an added layer to security.

The public key must be put inside the server. There are two methods to do it -

**Long Way -**

    Copy the contents of **id_rsa.pub** and paste it into the server's ssh folder(if not there, then create it using `mkdir .ssh`) inside filename **authorized_keys**.

**Short way -**

```bash
 ssh-copy-id -i PUBLIC_KEY_LOCATION USER@HOST_IP
```

    The above way is shorter for copying the public key to remote server.

    PUBLIC_KEY_LOCATION is the location where the public key is stored.(mostly in ~/.ssh/id_rsa.pub)

    USER@HOST_IP is same as login into server through SSH.

    For ex -

```bash
ssh-copy-id -i ~/.ssh/id_rsa.pub root@192.168.21.10        
```

![](C:\Users\kharw\AppData\Roaming\marktext\images\2022-09-07-21-19-27-image.png)

---

### <u>Managing SSH keys</u>

We can use RSA Encryption or any other encryption too.

For ex, generating keys using ed25519 encryption which is better and shorter than rsa.

```bash
ssh-keygen -t ed25519 -C "This is a comment"
```

We should be giving it a modified name too for identification.

Copy the public key into the server.

```bash
ssh-copy-id -i PATH_TO_KEY USER@HOST_IP
```

**Choosing which private key to login with -**

```bash
ssh -i PRIVATE_KEY_FULL_PATH USER@HOST_IP
```

**REMEMBER TO CHOOSE THE PRIVATE KEY, NOT PUBLIC KEY**

If we want to store the identity, we need to run the ssh-agent, to do this -

```bash
eval "$(ssh-agent)"
```

    Will return and start the ssh-agent.

Then,

```bash
ssh-add ~/.ssh/Private_key 
```

This will prompt us a passphrase, once entered, it will not ask for passphrase to us as the passphrase will be cached into memory.

**Hardening**

On the server, inside the **sshd_config** inside **/etc/ssh/** folder, we need to change few things to make the ssh connection more secure.

1. Changing the port to any other port than 22, then `ssh -p NEW_PORT .....` to login

2. Uncommenting the **PasswordAuthentication yes** to **PasswordAuthentication no**, which disables password login

3. Disable root login by uncommenting the **PermitRootLogin yes** to **PermitRootLogin no**, in this way no one through ssh will be able to login as root.

---

### <u>Troubleshooting SSH</u>
