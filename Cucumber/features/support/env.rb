require 'rubygems'
require 'selenium-webdriver'
require 'rspec/expectations'
require './features/pages/parkcalc'

# before all
selenium_driver = Selenium::WebDriver.for :firefox
$parkcalc = ParkCalcPage.new(selenium_driver)

# after all
at_exit do
	selenium_driver.quit
end
