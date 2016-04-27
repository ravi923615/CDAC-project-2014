Ext.Loader.setConfig({
    enabled: true
});
Ext.Loader.setPath('Ext.ux', '../ext/examples/ux');

Ext.require([
    //'Ext.form.*',
    //'Ext.layout.container.Column',
    //'Ext.tab.Panel'
    '*',
    'Ext.ux.DataTip'
]);

Ext.onReady(function() {
    Ext.QuickTips.init();

    var bd = Ext.getBody();

    /*
     * ================  Simple form  =======================
     */
    bd.createChild({tag: 'h2', html: 'Register'});

    var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
	
	
/*   Phone input vtype...... */	
	var phoneNumber = {
    telNumber: function(val, field){
         var telNumberRegex = /^\d{10}$/;
    return telNumberRegex.test(val);
    },
    telNumberText: 'Your Mobile or Phone Number max 10 numbers',
    telNumberMask: /[\d\-]/
};
Ext.apply(Ext.form.field.VTypes, phoneNumber);


/*   Password matching vtype...... */
Ext.apply(Ext.form.field.VTypes, {
    password: function(val, field){
	 var parentForm = field.up('form'); // get parent form
    
    // get the form's values
var formValues = parentForm.getValues();
    
    // get the value from the configured 'First Password' field
    var firstPasswordValue = formValues[field.firstPasswordFieldName];
    // return true if they match
    return val == firstPasswordValue;
	
        return false;
    },
    
    passwordText: 'Your Passwords do not match.'
});



    var simple = Ext.widget({
        xtype: 'form',
        layout: 'form',
        collapsible: true,
        id: 'register',
        url: 'http://localhost:8080/test/index.html',
        frame: true,
        title: 'Registration Form',
        bodyPadding: '5 5 0',
        width: 600,
		hieght: 600,
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 75
        },
        plugins: {
            ptype: 'datatip'
        },
        defaultType: 'textfield',
		renderTo: 'abc',
        items: [{
            fieldLabel: 'First Name',
            afterLabelTextTpl: required,
            name: 'first',
            allowBlank: false,
            tooltip: 'Enter your first name'
        },{
            fieldLabel: 'Last Name',
            afterLabelTextTpl: required,
            name: 'last',
            allowBlank: false,
            tooltip: 'Enter your last name'
        },{
            fieldLabel: 'Company',
            name: 'company',
            tooltip: "Enter your employer's name"
        }, {
            fieldLabel: 'Email',
            afterLabelTextTpl: required,
            name: 'email',
            allowBlank: false,
            vtype:'email',
            tooltip: 'Enter your email address'
        }, {
            fieldLabel: 'DOB',
            name: 'dob',
            xtype: 'datefield',
            tooltip: 'Enter your date of birth'
        }, {
            fieldLabel: 'Phone(opt)',
            name: 'PhoneNumber',
			vtype: 'telNumber',
            tooltip: 'Enter your date of birth'
        }, {
            fieldLabel: 'Mobile',
			afterLabelTextTpl: required,
            name: 'Mobile',
			regex: /[1-9-]*/,
			vtype: 'telNumber',
			allowBlank:false,
            tooltip: 'Enter your Mobile Number Here'
        },{
            fieldLabel: 'Password',
			inputType: 'password',
            afterLabelTextTpl: required,
            name: 'pass',
			id: 'pass',
            allowBlank: false,
            tooltip: 'Enter your preferred password'
        },{
            fieldLabel: 'Confirm Password',
            afterLabelTextTpl: required,
			inputType: 'password',
            name: 'Cpass',
			vtype: 'password',
			firstPasswordFieldName: 'pass',
            allowBlank: false,
            tooltip: 'Enter the password you entered above'
        }],

        buttons: [{
            text: 'Register',
            handler: function() {
                this.up('form').getForm().submit(
				{
					method:'POST',
					url: 'http://localhost:8080/test/index.html',
					reset: false,
					waitTitle: "Please Wait",
					waitMsg: 'Saving ...',
					success: function(form, action) {
					alert('form submitted..!!');
					},
					failure: function(form, action) {
					alert('form submit failed..');
					}
				});
            }
        },{
            text: 'Cancel',
            handler: function() {
                this.up('form').getForm().reset();
            }
        }]
    });
	 });