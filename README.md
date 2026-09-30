Structure:**

Project Root
│
├── Profiles
│   ├── default                      # Default execution configuration
│   ├── SIT\_DEV                      # SIT environment configuration
│   └── Test\_UAT                     # UAT environment configuration
│
├── Test Cases
│   ├── MOBILE                       # Mobile automation (future scope)
│   │
│   └── WEB
│       └── Workplace Address
│           ├── Add Workplace non Malaysian Citizen   # Add Workplace address (Non-Malaysian flow)
│           └── Add Workplace with Malaysian Citizen  # Add Workplace address (Malaysian flow)
│
├── Object Repository
│   ├── Guided Tour                  # Guided tour elements (Next / Done)
│   ├── Home                         # Dashboard / Home page elements
│   ├── Login                        # Login page objects
│   ├── Terms and Condition          # Terms acceptance elements
│   └── Workplace Address            # Workplace address form elements
│
├── Test Suites
│   └── Workplace Test Suites        # Main execution suite
│
├── Data Files                       # Test Data getting from Address file (Excel)
├── Checkpoints                      # Validation checkpoints (optional)
│
├── Keywords
│   └── common
│       ├── Helper\_Functions.groovy  # Reusable utility methods (click, setText, screenshots)
│       ├── GuidedTour\_Screens.groovy# Guided tour handling logic
│       ├── Login.groovy             # Reusable login keyword
│       ├── Workplace\_Address.groovy # Workplace address flow methods
│       └── term\_and\_condition.groovy# Terms \& condition handling
│
├── Test Listeners                   # Screenshot function (after execution)
├── Reports                          # Execution reports \& screenshots
├── Include                          # Internal framework configs
├── Plugins                          # Installed Katalon plugins
│
├── .gitignore                       # Git ignored files
├── build.gradle                     # Build configuration
├── console.properties               # CLI execution settings
└── README.md                        # Project documentation



**Execution Flow:**

1- Login
2- Handle Guided Tour (if appears)
3- Navigate to Workplace Address
4- Add / Update Workplace Address (Malaysia and Non Malaysian citizen)
5- Validate successful save



**Key Components**

Reusable Keywords
1- Helper\_Functions
clickWhenVisible → Safe click with wait \& scroll
setTextField → Safe text input

2- step\_screenshot → Logging + screenshot
Login
Centralized login logic
Used across all test cases

3- Workplace\_Address
Handles Add / Update flows

**Author:**

Syed Talha Ghayas
Role: Automation Tester

