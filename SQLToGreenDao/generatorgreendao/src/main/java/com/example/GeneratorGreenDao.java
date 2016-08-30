package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class GeneratorGreenDao {

public static void main(String[] args) throws Exception {
	Schema schema = new Schema(1000, "de.greenrobot.daoexample");

//	addNotegroup_user(schema);
//	addNotegroup(schema);
//	addNoteuser(schema);
//	addNotecategory(schema);
	addAutoTag(schema);

	new DaoGenerator().generateAll(schema, "../app/src/main/java");
}

 private static void addNotegroup_user(Schema schema){
	 Entity note = schema.addEntity("Group_user");

	 note.addIntProperty("id");
	 note.addIntProperty("user_id");
	 note.addIntProperty("group_id");
}
 private static void addNoteuser(Schema schema){
	 Entity note = schema.addEntity("User");

	 note.addIntProperty("id");
	 note.addStringProperty("name");
	 note.addStringProperty("email");
	 note.addDateProperty("create_at");
	 note.addDateProperty("update_at");
	 Property property = note.addIntProperty("group_id").getProperty();
	 note.addToOne(noteGroup, property);

}

	public static Entity noteGroup;
 private static void addNotegroup(Schema schema){
	 noteGroup = schema.addEntity("Group");

	 noteGroup.addIntProperty("id");
	 noteGroup.addStringProperty("name");
	 noteGroup.addStringProperty("description");
}
 private static void addNotecategory(Schema schema){
	 Entity note = schema.addEntity("Category");

	 note.addIntProperty("id");
	 note.addStringProperty("categorycol");
	 note.addStringProperty("categorycol1");
	 note.addDateProperty("categorycol2");
	 note.addByteProperty("categorycol3");
	 note.addStringProperty("categorycol4");
	 note.addStringProperty("categorycol5");
	 note.addByteProperty("categorycol6");
	 note.addByteProperty("categorycol7");
	 note.addByteProperty("categorycol8");
	 note.addByteProperty("categorycol9");
	 note.addStringProperty("categorycol10");
	 note.addDateProperty("categorycol11");
	 note.addStringProperty("categorycol12");
	 note.addStringProperty("categorycol13");
	 note.addStringProperty("categorycol14");
	 note.addStringProperty("categorycol15");
	 note.addStringProperty("categorycol16");
	 note.addStringProperty("categorycol17");
	 note.addStringProperty("categorycol18");
	 note.addStringProperty("categorycol19");
	 note.addStringProperty("categorycol20");
	 note.addStringProperty("categorycol21");
	 note.addStringProperty("categorycol22");
}


	private static void addAutoTag(Schema schema) {
		Entity note = schema.addEntity("AutoTag");
		note.addIdProperty();
		note.addStringProperty("name");
		note.addBooleanProperty("checked");
	}
}
