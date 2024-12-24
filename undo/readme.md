
requirements: kind of live code editor but can write anything instead of only code.

code a TextPad with following functionality:

display() – to display the entire content
display(n, m) – to display from line n to m
insert(n, text) – to insert text at line n
delete(n) – delete line n
delete(n, m) – delete from line n to m
copy(n, m) – copy contents from line n to m to clipboard
paste(n) – paste contents from clipboard to line n
undo() – undo last command
redo() – redo last command
expected the textpad to be in memory(not as file) and also expected to handle error gracefully and the program to be menu driven.

/createDocument()
/addUserToDocument(user)
/editDocument(msg)

class Message{
    User createdBy
    string content;

    +createMessage(contentToAdd);
}

class Document{
    map<msg, user> contentAddedByUser; map<userId, user> usersInovlved;  map<user,stack<msg>> lastMsg;

    +createDocument();
    +editDocument();{

    }
    +addUser(user){
        this.usersInvolved[user.userId]=user;
    }
    +display();
}

class user{
    map<documentId, Document> documentsInvolved; 

    string userId;

    +undoLastMsg{

    }
    +redoLastMsg{

    }
    +createDocument{

    }
}

class application{
    map<document, user>

    main{
        application = new application();
        application.initialize();
    }
}


