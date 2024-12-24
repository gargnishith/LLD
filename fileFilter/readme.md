Requirement:

Design Unix File Search API to search file with different arguments as "extension", "name", "size" ...
The design should be maintainable to add new contraints.


/findFileBy()
/addNewFilter

ENUM FilterBy : [extension, name, size, createdBy, createdAt]




interface spec{

    default isPass(map<filterBy, string> filterParams, file)
}

class extensionSpec implement spec{

    @override
    bool isPass(map<filterBy, string> filterParams, file){
        /// do code fo exception match
    }
}

class nameSpec implement spec{

    @override
    bool isPass(map<filterBy, string> filterParams, file){
        /// do code fo name match
    }
}

class SizeSpec implement spec{}
class CreatedBySpec implement spec{}
class CreatedAtSpec implement spec{}
class OrSpec implment spec
class AndSpec implment spec{
    spec spec1, spec spec2;
    AndSpec(spec spec1, spec spec2){
        spec1 = spec1; spec2 = spec2;
    }
    @override
    bool isPass(map<filterBy, string> filterParams, file){
        return spec1.isPass((filterParams, file))&&spec2.isPass((filterParams, file))
    }
}

interface fileSystem{
    +getExtension();
}

class Directory implements FileSystem{
    List<FileSystem> filesInDirectory;
    
    +add(FileSystem) filesInDirectory.push(FileSystem);
    +getExtension{
        for each fileSystem in filesInDirectory fileSystem.extension;
    }
}

class File implements FileSystem{

    +getExtension return this.extension
}

class FilterSystem{
    map<filterId, filter> filtersAvailable; List<file> filesToFilter;  map<filterBy, string> filterParams;
    List<Directory> 
    main{
        filterSystem = new FilterSystem();
        spec = new AndSpec(extensionSpec, OrSpec(nameSpec, sizeSpec)); filterParams[extension] = ".txt"
        filterSystem.filter(filesToFilter, spec);
    }

    +intialize(){
        //put files in filesToFilter for a loop
        //iniitalize the filtersAvailable and filterParams by default values;
    }
    +filter(filesToFilter, spec){
        list<file> result;
        for(each file in filesToFilter) if(spec.isPass(filterParams, file)==true) result.push(file);
    }
}

