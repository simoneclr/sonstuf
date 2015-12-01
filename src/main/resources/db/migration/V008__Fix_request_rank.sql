ALTER TABLE sonstuf.requesterrank DROP FOREIGN KEY fk_requesterrank_offer1;
ALTER TABLE sonstuf.requesterrank DROP PRIMARY KEY;
ALTER TABLE sonstuf.requesterrank CHANGE idoffer idrequest int NOT NULL;
ALTER TABLE sonstuf.requesterrank
ADD CONSTRAINT fk_requesterrank_offer1
FOREIGN KEY (idrequest) REFERENCES offer (idoffer);
ALTER TABLE sonstuf.requesterrank ADD PRIMARY KEY (idrequest);