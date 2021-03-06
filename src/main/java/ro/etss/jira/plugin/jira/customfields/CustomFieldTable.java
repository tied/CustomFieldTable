package ro.etss.jira.plugin.jira.customfields;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.jira.imports.project.customfield.ProjectCustomFieldImporter;
import com.atlassian.jira.imports.project.customfield.ProjectImportableCustomField;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.AbstractSingleFieldType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.customfields.persistence.PersistenceFieldType;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

@Scanned
public class CustomFieldTable extends AbstractSingleFieldType<String> implements ProjectImportableCustomField{
    
	private static final Logger log = LoggerFactory.getLogger(CustomFieldTable.class);
    
    private final ProjectCustomFieldImporter projectCustomFieldImporter; 

    public CustomFieldTable(@ComponentImport CustomFieldValuePersister customFieldValuePersister, 
    					    @ComponentImport GenericConfigManager genericConfigManager) {
    super(customFieldValuePersister, genericConfigManager);
    		projectCustomFieldImporter = new ProjectCustomFieldImporterImplem();
    }
    
    @Override
	public Map<String, Object> getVelocityParameters(Issue issue, CustomField field, FieldLayoutItem fieldLayoutItem) {
		Map<String, Object> velocityParameters = super.getVelocityParameters(issue, field, fieldLayoutItem);
		log.info("++++++++++++++++++++getVelocityParameters++++++++++++++++++++");
		return velocityParameters;
	}

	@Override
	public String getSingularObjectFromString(String arg0) throws FieldValidationException {
		log.info("++++++++++++++++++++getSingularObjectFromString++++++++++++++++++++");
		return arg0;
	}

	@Override
	public String getStringFromSingularObject(String arg0) {
		log.info("++++++++++++++++++++getStringFromSingularObject++++++++++++++++++++");
		return arg0;
	}

	@Override
	public ProjectCustomFieldImporter getProjectImporter() {
		log.info("++++++++++++++++++++getProjectImporter++++++++++++++++++++");
		return projectCustomFieldImporter;
	}

	@Override
	protected PersistenceFieldType getDatabaseType() {
		log.info("++++++++++++++++++++getDatabaseType++++++++++++++++++++");
		return PersistenceFieldType.TYPE_UNLIMITED_TEXT;
	}

	@Override
	protected Object getDbValueFromObject(String arg0) {
		log.info("++++++++++++++++++++getDbValueFromObject++++++++++++++++++++");
		return arg0;
	}

	@Override
	protected String getObjectFromDbValue(Object arg0) throws FieldValidationException {
		log.info("++++++++++++++++++++getObjectFromDbValue++++++++++++++++++++");
		return arg0.toString();
	}
	
}