Icon name = new Icon();  #creates an icon, but does not display anything
name.setType(int toSet);  #sets the type: 0 is none, clears line; 1 is spinner, cycles chars |/-\; 2 is progressBar, shows a bar EXAMPLE: |██████████████████████████████| ${text}100%
name.update(double progress, double total, Sting text);  #updates the icon depending on the type (see above)
String type = name.type();  #returns the type in a string
String toString = name.toString();  #returns "Loading icon of type : ${type}"
