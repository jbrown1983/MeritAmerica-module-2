-- 12. The state name, nickname, and sales tax from records in the state table in the "West" and "South" census regions with a sales tax that isn't 0% (26 rows)

Select state_name, state_nickname, sales_tax
from state
where census_region = 'West' and sales_tax > 0
or census_region = 'South' and sales_tax > 0

