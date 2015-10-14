package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class GeneratorGreenDao {

public static void main(String[] args) throws Exception {
	Schema schema = new Schema(1000, "de.greenrobot.daoexample");


	addNotegroup_user(schema);
	addNoteuser(schema);
	addNotegroup(schema);
	new DaoGenerator().generateAll(schema, "../app/src/main/java");
}


 private static void addNotegroup_user(Schema schema){
	 Entity note = schema.addEntity("group_user");
	 note.addIntProperty("id");
	 note.addIntProperty("user_id");
	 note.addIntProperty("group_id");
}
 private static void addNoteuser(Schema schema){
	 Entity note = schema.addEntity("user");
	 note.addIntProperty("id");
	 note.addStringProperty("name");
}
 private static void addNotegroup(Schema schema){
	 Entity note = schema.addEntity("group");
	 note.addIntProperty("id");
	 note.addStringProperty("name");
}
}