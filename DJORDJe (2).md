## Setup - running it for the first time

- Install NodeJS
- Install Cypress with `npm install cypress --save-dev`

## Running

To open cypress in the command line for DEV environment run

`node_modules/cypress/bin/cypress open --config-file=cypress.dev.json`

### API Tests

To run API tests on DEV env in command line run

`npx cypress run --spec 'cypress/integration/API_tests/**/*' --config-file='cypress.dev.json'`

To run API tests on STAGING env in command line run

`npx cypress run --spec 